import chromadb
from sentence_transformers import SentenceTransformer, util
from ollama import chat

# Load pretrained embedding model
model = SentenceTransformer("all-MiniLM-L6-v2")

# Connect to existing chromaDB
client = chromadb.PersistentClient(path="./MarvellousDB")

# Open collection
collection = client.get_collection(name = "Marvellous_Knowledge")

# Accept question
query = input("Enter your question: ")

# Generate query embedding
query_embedding = model.encode(
    query,
    convert_to_tensor=True
)

# Retrieve top 2 results
results = collection.query(query_embeddings = [query_embedding.tolist()], n_results = 2)

# Create context from retrieved documents
documents = results["documents"][0]

context = "\n".join(documents)

print("Retrieved context :\n",context)

# Create prompt for LLM
prompt = f"""
            Answer the question using only the given context.

            Context : {context}

            Question : {query}

            If the answer is not available in context,
            Say "Information not available."
         """


# Send the context and question to ollama(llama)
response = chat(
    model = "llama3.2:1b",
    messages = [
        {
            "role" : "user",
            "content" : prompt
        }
    ]
)

answer = response.message.content

print("Marvellous GenAI : RAG answer : ")
print(answer)

# ha code run kraychya adhi 17, 18 no chi file pahile run kraychi 