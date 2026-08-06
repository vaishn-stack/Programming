import pandas as pd

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





# Pandas - 1) Series(1D Array), 2) DataFrame(df)(2D Array), 3) Panel(3D Array) - remove
# shape - property
# If data can be missing used --> 1)rows are removed, b2)lank spaces put the average values
# Canonical function call