actual = [1, 1, 1, 1, 0, 0, 0, 0]

predicted = [1, 1, 0, 1, 0, 1, 0, 0]

TP = 0
TN = 0
FP = 0
FN = 0

for i in range(len(actual)):

    if actual[i] == 1 and predicted[i] == 1:
        TP = TP + 1

    elif actual[i] == 0 and predicted[i] == 0:
        TN = TN + 1

    elif actual[i] == 0 and predicted[i] == 1:
        FP = FP + 1

    elif actual[i] == 1 and predicted[i] == 0:
        FN = FN + 1

print("True Positive  (TP) :", TP)
print("True Negative  (TN) :", TN)
print("False Positive (FP) :", FP)
print("False Negative (FN) :", FN)