 // Accept distance in kilometer and convert it into meter.(1Kilometer = 1000 Meter)

 #include<stdio.h>

 int KMtoMeter(int iNo)
 {
    int iMeter = 0;

    iMeter = iNo * 1000;

    return iMeter;
 }

 int main()
 {
    int iValue = 0, iRet = 0;

    printf("Enter Distance : ");
    scanf("%d",&iValue);

    iRet = KMtoMeter(iValue);

    printf("");

    return 0;
 }