
import streamlit as st
import chromadb
from sentence_transformers import SentenceTransformer
from ollama import chat

# Page configuration
st.set_page_config(
    page_title="Marvellous GenAI - RAG",
    page_icon="🤖",
    layout="wide"
)

st.title("🤖 Marvellous GenAI - RAG Chatbot")
st.write("Ask questions from your knowledge base.")

# Load embedding model
@st.cache_resource
def load_model():
    return SentenceTransformer("all-MiniLM-L6-v2")


# Load ChromaDB collection
@st.cache_resource
def load_database():
    client = chromadb.PersistentClient(
        path="./MarvellousDB"
    )

    return client.get_collection(
        name="Marvellous_Knowledge"
    )


# Initialize resources
try:
    model = load_model()
    collection = load_database()

    st.success(
        f"Knowledge Base Loaded: {collection.count()} documents"
    )

except Exception as e:
    st.error(
        "Database not found. Run "
        "17_GenAI_Semantic_Search_Chromadb.py first."
    )
    st.code(str(e))
    st.stop()


# Question input
query = st.text_input(
    "Enter your question:",
    placeholder="Example: What is Python used for?"
)

if st.button("Generate Answer", type="primary"):

    if not query.strip():
        st.warning("Please enter a question.")

    elif collection.count() == 0:
        st.warning("The knowledge base is empty.")

    else:
        try:
            # Generate query embedding
            with st.spinner("Searching knowledge base..."):
                query_embedding = model.encode(
                    query
                ).tolist()

                # Retrieve top 2 documents
                results = collection.query(
                    query_embeddings=[query_embedding],
                    n_results=min(2, collection.count()),
                    include=["documents", "distances"]
                )

                documents = results["documents"][0]
                distances = results["distances"][0]

                context = "\n".join(documents)

            # Show retrieved documents
            st.subheader("📚 Retrieved Context")

            for i, document in enumerate(documents):
                with st.expander(f"Document {i + 1}"):
                    st.write(document)

                    similarity = 1 - distances[i]

                    st.write(
                        f"Cosine similarity: {similarity:.4f}"
                    )

            # Build RAG prompt
            prompt = f"""
Answer the question using only the provided context.

If the answer is not available in the context,
reply exactly: Information not available.

Context:
{context}

Question:
{query}

Answer:
"""

            # Generate answer using Ollama
            st.subheader("💬 Marvellous GenAI Answer")

            with st.spinner("Generating answer with Llama..."):
                response = chat(
                    model="llama3.2:1b",
                    messages=[
                        {
                            "role": "user",
                            "content": prompt
                        }
                    ]
                )

                answer = response.message.content

            st.markdown(answer)

        except Exception as e:
            st.error(
                "An error occurred while processing your question."
            )
            st.code(str(e))
            st.info(
                "Check that MarvellousDB exists and Ollama "
                "is running with llama3.2:1b installed."
            )
