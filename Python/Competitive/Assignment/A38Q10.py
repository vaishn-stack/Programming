import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("student_performance_ml.csv")

plt.scatter(df["SleepHours"],
            df["FinalResult"])

plt.title("SleepHours vs FinalResult")

plt.xlabel("SleepHours")
plt.ylabel("FinalResult")

plt.show()