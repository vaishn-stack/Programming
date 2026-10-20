
import streamlit as st
import chromadb
from sentence_transformers import SentenceTransformer
from ollama import chat

# ---------------- PAGE CONFIG ----------------

st.set_page_config(
    page_title="Marvellous GenAI - RAG",
    page_icon="🤖",
    layout="wide"
)

st.title("🤖 Marvellous GenAI - RAG Chatbot")
st.write("Ask questions from your knowledge base using RAG.")

# ---------------- KNOWLEDGE BASE ----------------

documents = [
    "Python is used for machine learning",
    "Java is used for enterprise applications",
    "SQL is used to manage databases",
    "HTML is used to create web pages",
    "TensorFlow is used for deep learning"
]

document_ids = [
    "doc1", "doc2", "doc3", "doc4", "doc5"
]

# ---------------- LOAD EMBEDDING MODEL ----------------

@st.cache_resource
def load_model():
    return SentenceTransformer("all-MiniLM-L6-v2")


# ---------------- CREATE / LOAD DATABASE ----------------

@st.cache_resource
def load_database():
    model = load_model()

    client = chromadb.PersistentClient(
        path="./MarvellousDB"
    )

    collection = client.get_or_create_collection(
        name="Marvellous_Knowledge",
        metadata={"hnsw:space": "cosine"}
    )

    # Insert or update hard-coded documents
    embeddings = model.encode(documents).tolist()

    collection.upsert(
        ids=document_ids,
        documents=documents,
        embeddings=embeddings
    )

    return collection


# ---------------- INITIALIZE ----------------

try:
    model = load_model()
    collection = load_database()

    st.success(
        f"Knowledge Base Loaded: {collection.count()} documents"
    )

except Exception as e:
    st.error("Unable to load the knowledge base.")
    st.exception(e)
    st.stop()


# ---------------- USER QUESTION ----------------

query = st.text_input(
    "Enter your question:",
    placeholder="Example: What is Python used for?"
)

if st.button("Generate Answer", type="primary"):

    if not query.strip():
        st.warning("Please enter a question.")

    else:
        try:
            # ---------------- RETRIEVAL ----------------

            with st.spinner("Searching knowledge base..."):

                query_embedding = model.encode(
                    query
                ).tolist()

                results = collection.query(
                    query_embeddings=[query_embedding],
                    n_results=min(2, collection.count()),
                    include=["documents", "distances"]
                )

                documents_found = results["documents"][0]
                distances = results["distances"][0]

                context = "\n".join(documents_found)

            # ---------------- DISPLAY CONTEXT ----------------

            st.subheader("📚 Retrieved Context")

            for i, document in enumerate(documents_found):

                with st.expander(f"Document {i + 1}"):

                    st.write(document)

                    similarity = 1 - distances[i]

                    st.write(
                        f"Cosine similarity: {similarity:.4f}"
                    )

            # ---------------- BUILD PROMPT ----------------

            prompt = f"""
You are a helpful RAG assistant.

Answer the question using only the provided context.
If the answer is not available in the context,
reply exactly: Information not available.

Context:
{context}

Question:
{query}

Answer:
"""

            # ---------------- GENERATE ANSWER ----------------

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
            st.error("Unable to generate the answer.")
            st.exception(e)

            st.info(
                "Verify that the Ollama server is reachable "
                "and the llama3.2:1b model is available."
            )
