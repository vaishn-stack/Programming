import pandas as pd

df = pd.read_csv("student_performance_ml.csv")

print("Average StudyHours : ", df["StudyHours"].mean())

print("Average Attendance : ", df["Attendance"].mean())

print("Maximum PreviousScore : ", df["PreviousScore"].max())

print("Minimum SleepHours : ", df["SleepHours"].min())