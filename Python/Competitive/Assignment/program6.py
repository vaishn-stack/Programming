# Factors

class NumberX:
    def DisplayFactors(self, No):
        for iCnt in range(1, No):
            if (No % iCnt) == 0:
                print(iCnt)

Value = int(input("Enter number : "))

nobj = NumberX()
nobj.DisplayFactors(Value)