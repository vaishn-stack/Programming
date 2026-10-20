import chromadb
from sentence_transformers import SentenceTransformer
from sentence_transformers import util

# Load pretrained embedding model
model = SentenceTransformer("all-MiniLM-L6-v2")

# Knowledge base
documents = [
    "Python is used for machine learning",
    "Java is used for enterprise applications",
    "SQL is used to manage databases",
    "HTML is used to create web pages",
    "TensorFlow is used for deep learning"
]

# Generate document embeddings
document_embedding = model.encode(
    documents,
    convert_to_tensor=True
)

# create chromadb client
client = chromadb.PersistentClient(path="./MarvellousDB")

# create collection
# HNSW = Hierarchical Navigable small word
collection = client.get_or_create_collection(
    name = "Marvellous_Knowledge",
    configuration = {"HNSW" : {"space" : "cosine"}},
)

# Store documents and embeddings
collection.upsert(
    ids = ["doc1", "doc2", "doc3", "doc4", "doc5"],
    documents = documents,
    embeddings = document_embedding.tolist()
)

print("Total documents : ", collection.count())

# Accept question
query = input("Enter your question: ")

# Generate query embedding
query_embedding = model.encode(
    query,
    convert_to_tensor=True
)

# Calculate cosine similarity
scores = util.cos_sim(
    query_embedding,
    document_embedding
)[0]

# Find top 2 matching documents
top_result = scores.topk(2)

print("\nTop 2 relevant documents :")

for index in top_result.indices:
    print(
        f"- {documents[index.item()]} "
        f"(Score: {scores[index].item():.4f})"
    )
