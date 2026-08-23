import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeRegressor
from sklearn.ensemble import BaggingRegressor
from sklearn.metrics import mean_squared_error, r2_score

#--------------------------------------------------------------
# step 1 : Load the dataset
#--------------------------------------------------------------

df = pd.read_csv("california_housing.csv")
print("Shape of DataSet : ", df.shape)
print("First Few Records : ", df.head())

#--------------------------------------------------------------
# step 2 : Separate the features and labels
#--------------------------------------------------------------

X = df.drop("target", axis = 1)
Y = df["target"]

print("Shape of X : ", X.shape)
print("Shape of Y : ", Y.shape)

#--------------------------------------------------------------
# step 3 : Split dataset for training and testing
#--------------------------------------------------------------

X_train, X_test, Y_train, Y_test = train_test_split(
                                                       X,
                                                       Y,
                                                       test_size = 0.2,
                                                       random_state = 42
                                                   )

#--------------------------------------------------------------
# step 4.1 : Create the base model
#--------------------------------------------------------------

base_model = DecisionTreeRegressor(random_state = 42)

#--------------------------------------------------------------
# step 4.2 : Create the bagging model
#--------------------------------------------------------------

model = BaggingRegressor(
                            estimator=base_model,
                            n_estimators=10,
                            random_state=42
                        )

#--------------------------------------------------------------
# step 5 : Train the model
#--------------------------------------------------------------

model = model.fit(X_train, Y_train)

#--------------------------------------------------------------
# step 6 : Test the model
#--------------------------------------------------------------

Y_pred = model.predict(X_test)

#--------------------------------------------------------------
# step 7 : Evaluate the model
#--------------------------------------------------------------

print("MSE : ", mean_squared_error(Y_test, Y_pred))
print("R2 : ", r2_score(Y_test, Y_pred))



