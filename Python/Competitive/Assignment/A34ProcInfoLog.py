import psutil
import os
import sys


def ValidateInput():
    if len(sys.argv) != 2:
        print("Usage : python ProcInfoLog.py <DirectoryName>")
        sys.exit()


def CreateDirectory(dirname):
    if not os.path.exists(dirname):
        os.mkdir(dirname)


def CreateLogFile(dirname):
    filepath = os.path.join(dirname, "ProcessLog.txt")

    file = open(filepath, "w")

    file.write("Name\t\tPID\t\tUsername\n")
    file.write("=" * 50 + "\n")

    for proc in psutil.process_iter(['pid', 'name', 'username']):
        try:
            file.write(f"{proc.info['name']}\t{proc.info['pid']}\t{proc.info['username']}\n")
        except (psutil.NoSuchProcess,
                psutil.AccessDenied,
                psutil.ZombieProcess):
            pass

    file.close()
    print("Log file created successfully at :", filepath)


def main():
    try:
        ValidateInput()

        dirname = sys.argv[1]

        CreateDirectory(dirname)
        CreateLogFile(dirname)

    except Exception as e:
        print("Error :", e)


if __name__ == "__main__":
    main()