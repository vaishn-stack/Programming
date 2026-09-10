import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.impute import SimpleImputer

from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier

from sklearn.ensemble import VotingClassifier

from sklearn.metrics import accuracy_score


# ---------------------------------------------------
# 1. Load Dataset
# ---------------------------------------------------

df = pd.read_csv("Customer_Loan_Approval.csv")

print("Dataset:")
print(df.head())

print("\nDataset Shape:")
print(df.shape)


# ---------------------------------------------------
# 2. Check Missing Values
# ---------------------------------------------------

print("\nMissing Values:")
print(df.isnull().sum())


# ---------------------------------------------------
# 3. Separate Input and Output Variables
# ---------------------------------------------------

X = df.drop("LoanApproved", axis=1)
y = df["LoanApproved"]


# ---------------------------------------------------
# 4. Handle Missing Values
# ---------------------------------------------------

imputer = SimpleImputer(strategy="mean")

X = pd.DataFrame(
    imputer.fit_transform(X),
    columns=X.columns
)


# ---------------------------------------------------
# 5. Split Dataset
# ---------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
    stratify=y
)


# ---------------------------------------------------
# 6. Feature Scaling
# ---------------------------------------------------

scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)


# ---------------------------------------------------
# 7. Create Individual Models
# ---------------------------------------------------

lr = LogisticRegression(random_state=42)

dt = DecisionTreeClassifier(
    random_state=42
)

knn = KNeighborsClassifier(
    n_neighbors=5
)


# ---------------------------------------------------
# 8. Train Logistic Regression
# ---------------------------------------------------

lr.fit(X_train_scaled, y_train)

lr_pred = lr.predict(X_test_scaled)

lr_accuracy = accuracy_score(
    y_test,
    lr_pred
)


# ---------------------------------------------------
# 9. Train Decision Tree
# ---------------------------------------------------

dt.fit(X_train, y_train)

dt_pred = dt.predict(X_test)

dt_accuracy = accuracy_score(
    y_test,
    dt_pred
)


# ---------------------------------------------------
# 10. Train KNN
# ---------------------------------------------------

knn.fit(X_train_scaled, y_train)

knn_pred = knn.predict(X_test_scaled)

knn_accuracy = accuracy_score(
    y_test,
    knn_pred
)


# ---------------------------------------------------
# 11. Hard Voting Classifier
# ---------------------------------------------------

hard_voting = VotingClassifier(
    estimators=[
        ("lr", LogisticRegression(random_state=42)),
        ("dt", DecisionTreeClassifier(random_state=42)),
        ("knn", KNeighborsClassifier(n_neighbors=5))
    ],
    voting="hard"
)

hard_voting.fit(
    X_train_scaled,
    y_train
)

hard_pred = hard_voting.predict(
    X_test_scaled
)

hard_accuracy = accuracy_score(
    y_test,
    hard_pred
)


# ---------------------------------------------------
# 12. Soft Voting Classifier
# ---------------------------------------------------

soft_voting = VotingClassifier(
    estimators=[
        ("lr", LogisticRegression(random_state=42)),
        ("dt", DecisionTreeClassifier(random_state=42)),
        ("knn", KNeighborsClassifier(n_neighbors=5))
    ],
    voting="soft"
)

soft_voting.fit(
    X_train_scaled,
    y_train
)

soft_pred = soft_voting.predict(
    X_test_scaled
)

soft_accuracy = accuracy_score(
    y_test,
    soft_pred
)


# ---------------------------------------------------
# 13. Display Accuracy
# ---------------------------------------------------

print("\nModel Accuracy:")

print(
    "Logistic Regression:",
    lr_accuracy
)

print(
    "Decision Tree:",
    dt_accuracy
)

print(
    "KNN:",
    knn_accuracy
)

print(
    "Hard Voting:",
    hard_accuracy
)

print(
    "Soft Voting:",
    soft_accuracy
)