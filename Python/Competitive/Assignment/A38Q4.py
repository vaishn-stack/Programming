import pandas as pd

df = pd.read_csv("student_performance_ml.csv")

count = df["FinalResult"].value_counts()

print(count)

percentage = df["FinalResult"].value_counts(normalize = True) * 100

print("\nPercentage : ")
print(percentage)

pass_per = percentage[1]
fail_per = percentage[0]

print("\nPass Percentage : ", round(pass_per,2), "%")
print("\nFail Percentage : ", round(fail_per,2), "%")

if abs(pass_per - fail_per) <= 10:
    print("\nDataset is balanced.")
else:
    print("\nDataset is not balanced.")