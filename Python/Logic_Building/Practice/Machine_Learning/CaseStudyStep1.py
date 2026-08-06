import pandas as pd

Border = "-"*40

################################################################################################################################
# Step 1 : Load the dataset
################################################################################################################################

print(Border)
print("Step 1 : Load the dataset")
print(Border)

DataPath = "iris.csv"

df = pd.read_csv(DataPath)

print("Dataset Loaded Successfully!")
print("Initial Entries from dataset are : ")
print(df.head())













# Pandas - 1) Series(1D Array), 2) DataFrame(df)(2D Array), 3) Panel(3D Array) - remove