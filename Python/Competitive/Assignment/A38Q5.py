import pandas as pd

df = pd.read_csv("student_performance_ml.csv")

print(df.groupby("FinalResult")["StudyHours"].mean())
print(df.groupby("FinalResult")["Attendance"].mean())