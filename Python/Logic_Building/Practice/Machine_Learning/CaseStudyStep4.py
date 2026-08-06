import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

Border = "-"*55

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

################################################################################################################################
# Step 2 : Exploratory Data Analysis( EDA)
################################################################################################################################

print(Border)
print("Step 2 : Exploratory Data Analysis( EDA)")
print(Border)

print("Shape of Dataset : ", df.shape)

print("Column names : ", list(df.columns))

print("Missing values per column : ")
print(df.isnull().sum())

print("Class Distribution (Species count)")
print(df["species"].value_counts())

print("Statistical report of dataset : ")
print(df.describe())

################################################################################################################################
# Step 3 : Decide Independent and Dependent variables
################################################################################################################################

print(Border)
print("Step 3 : Decide Independent and Dependent variables")
print(Border)

# X - Independent variable / Features
# Y - Dependent variable / Labels

feature_cols = [
                    "sepal length (cm)",
                    "sepal width (cm)",
                    "petal length (cm)",
                    "petal width (cm)"	
               ]

X = df[feature_cols]
Y = df["species"]

print("X Shape : ", X.shape)
print("Y Shape : ", Y.shape)

################################################################################################################################
# Step 4 : Visualisation of dataset
################################################################################################################################

print(Border)
print("Step 4 : Visualisation of dataset")
print(Border)

# Scatter plot
plt.figure(figsize=(7,5))

for sp in df["species"].unique():
     temp = df[df["species"] == sp]
     plt.scatter(temp["petal length (cm)"], temp["petal width (cm)"], label = sp)
     
plt.title("Marvellous Iris Case Study")
plt.xlabel("petal length (cm)")
plt.ylabel("petal width (cm)")

plt.legend()
plt.grid()
plt.show()














# Pandas - 1) Series(1D Array), 2) DataFrame(df)(2D Array), 3) Panel(3D Array) - remove
# shape - property
# If data can be missing used --> 1)rows are removed, b2)lank spaces put the average values
# Canonical function call - df.isnull().sum()