import streamlit as st
import chromadb
from sentence_transformers import SentenceTransformer
from groq import Groq

# ---------------- PAGE CONFIGURATION ----------------

st.set_page_config(
    page_title="Marvellous RAG Chatbot",
    page_icon="🤖",
    layout="wide"
)

st.title("🤖 Marvellous RAG Chatbot")
st.write("Ask questions and get answers using Retrieval-Augmented Generation.")

# ---------------- DOCUMENTS ----------------

documents = [
    "Python is used for machine learning",
    "Java is used for enterprise applications",
    "SQL is used to manage databases",
    "HTML is used to create web pages",
    "TensorFlow is used for deep learning"
]

ids = [f"doc{i}" for i in range(len(documents))]

# ---------------- LOAD EMBEDDING MODEL ----------------

@st.cache_resource
def load_model():
    return SentenceTransformer("all-MiniLM-L6-v2")

model = load_model()

# ---------------- CHROMADB ----------------

@st.cache_resource
def load_collection():
    client = chromadb.PersistentClient(path="./MarvellousDB")

    collection = client.get_or_create_collection(
        name="Marvellous_Knowledge",
        metadata={"hnsw:space": "cosine"}
    )

    embeddings = model.encode(documents).tolist()

    collection.upsert(
        ids=ids,
        documents=documents,
        embeddings=embeddings
    )

    return collection

collection = load_collection()

# ---------------- USER INPUT ----------------

query = st.text_input("Enter your question:")

if st.button("Get Answer") and query.strip():

    with st.spinner("Searching relevant information..."):

        query_embedding = model.encode([query]).tolist()

        results = collection.query(
            query_embeddings=query_embedding,
            n_results=2,
            include=["documents", "distances"]
        )

        retrieved_docs = results["documents"][0]
        distances = results["distances"][0]

        context = "\n".join(retrieved_docs)

    st.subheader("📚 Retrieved Context")

    for i, doc in enumerate(retrieved_docs):
        similarity = max(0, 1 - distances[i])

        st.write(f"**Document {i + 1}:** {doc}")
        st.write(f"Cosine similarity: {similarity:.4f}")

    # ---------------- GROQ LLM ----------------

    try:
        api_key = st.secrets["GROQ_API_KEY"]
        client = Groq(api_key=api_key)

        with st.spinner("Generating answer..."):

            response = client.chat.completions.create(
                model="llama-3.3-70b-versatile",
                messages=[
                    {
                        "role": "system",
                        "content": (
                            "Answer the user's question using the "
                            "provided context. If the answer is not "
                            "available in the context, clearly say so."
                        )
                    },
                    {
                        "role": "user",
                        "content": (
                            f"Context:\n{context}\n\n"
                            f"Question: {query}"
                        )
                    }
                ],
                temperature=0.2
            )

        st.subheader("💡 Answer")
        st.write(response.choices[0].message.content)

    except KeyError:
        st.error(
            "GROQ_API_KEY is missing. Add it in "
            "Streamlit Cloud App Settings → Secrets."
        )

    except Exception as e:
        st.error(f"Something went wrong: {e}")

elif st.button("Get Answer"):
    st.warning("Please enter a question first.")
