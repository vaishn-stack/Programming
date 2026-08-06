import pandas as pd

df = pd.read_csv("student_performance_ml.csv")

print("Total students : ", len(df))

print("Passed students : ", (df["FinalResult"] == 1).sum())

print("Failed students : ", (df["FinalResult"] == 0).sum())