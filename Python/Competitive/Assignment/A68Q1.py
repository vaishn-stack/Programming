# Program to manually perform convolution

# 5x5 Input Image
image = [
    [0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0],
    [1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0]
]

# 3x3 Edge Detection Kernel
kernel = [
    [-1, -1, -1],
    [ 0,  0,  0],
    [ 1,  1,  1]
]

# Feature map size
rows = len(image) - len(kernel) + 1
cols = len(image[0]) - len(kernel[0]) + 1

feature_map = []

# Move kernel over image
for i in range(rows):

    row = []

    for j in range(cols):

        total = 0

        print("\nRegion:")

        # Multiplication and addition
        for ki in range(3):

            for kj in range(3):

                value = image[i + ki][j + kj]
                k = kernel[ki][kj]

                print(
                    f"{value} * {k}",
                    end="   "
                )

                total += value * k

            print()

        print("Output =", total)

        row.append(total)

    feature_map.append(row)


print("\nFinal Feature Map:")

for row in feature_map:
    print(row)