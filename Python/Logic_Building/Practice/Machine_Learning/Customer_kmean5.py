import pandas as pd
import matplotlib.pyplot as plt

from sklearn.preprocessing import StandardScaler
from sklearn.cluster import KMeans

def main():
    # step1 : Load the data
    
    df = pd.read_csv("Mall_Customers.csv")
    print("Dataset loaded with values")
    print(df.head())
    
    print("Missing values : ")
    print(df.isnull().sum())
    
    # step 2 : feature selection
    X = df[["AnnualIncome", "SpendingScore"]]
    
    print("Selected features : ")
    print(X.head())
    
    # step 3: Scaled the data
    
    scalar = StandardScaler()
    
    X_Scaled = scalar.fit_transform(X)
    print("Scaled data : ")
    print(X_Scaled[:5])
    
    # step 4 : Elbow method
    WCSS = []
    
    for k in range(1, 11):
        model = KMeans(
            n_clusters = k,
            random_state = 42,
            n_init = 10
        )
        model.fit(X_Scaled)
        
        WCSS.append(model.inertia_)     # wcss chi value
        
    print("Values of WCSS : ")
    
    for i in range (len(WCSS)):
        print(f"{i + 1} : {WCSS[i]}")
        
    # step 5 : Visualize the data
    
    plt.plot(range(1,11), WCSS, marker = "o")
    plt.xlabel("Number of clusters : K")
    plt.ylabel("WCSS")
    plt.title("Marvellous Elbow method analysis")
    plt.grid(True)
    plt.show()
        

if __name__ == "__main__":
    main()