import matplotlib.pyplot as plt

def main():
    X = [1,2,3,4,5]
    Y = [10,25,18,35,30]
    
    plt.plot(
                X,              # Positional keywords - values of X-axis
                Y,              # values of y-axis
                marker = "o",   
                linestyle = "--",
                linewidth = 2,
                markersize = 7,
                label = "Marks"
            )
    
    plt.title("Marvellous Line Plot")
    plt.xlabel("Student Number")
    plt.ylabel("Marks")
    
    plt.grid(True)
    
    plt.legend()
    
    plt.show()
        
if __name__ == "__main__":
    main()