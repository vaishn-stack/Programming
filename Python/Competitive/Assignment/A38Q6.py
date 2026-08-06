import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("student_performance_ml.csv")

plt.hist(df["StudyHours"], bins = 10)

plt.title("Histogram of StudyHours")
plt.xlabel("StudyHours")
plt.ylabel("Frequency")

plt.show()

