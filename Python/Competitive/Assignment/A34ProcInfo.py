import psutil
import logging
import sys


def ConfigureLogger():
    logging.basicConfig(
        filename="ProcInfo.log",
        level=logging.INFO,
        format="%(asctime)s : %(message)s"
    )


def ValidateInput():
    if len(sys.argv) != 1:
        logging.error("Usage : python ProcInfo.py")
        sys.exit()


def DisplayProcesses():
    logging.info("========== Running Processes ==========")

    for proc in psutil.process_iter(['pid', 'name', 'username']):
        try:
            logging.info(
                f"Name : {proc.info['name']} | "
                f"PID : {proc.info['pid']} | "
                f"Username : {proc.info['username']}"
            )
        except (psutil.NoSuchProcess,
                psutil.AccessDenied,
                psutil.ZombieProcess):
            pass

    logging.info("=======================================")

def SearchProcess(ProcessName):
    found = False

    for proc in psutil.process_iter(['pid', 'name', 'username']):
        try:
            if proc.info['name'] and proc.info['name'].lower() == ProcessName.lower():
                found = True
                logging.info("========== Process Found ==========")
                logging.info(f"Name     : {proc.info['name']}")
                logging.info(f"PID      : {proc.info['pid']}")
                logging.info(f"Username : {proc.info['username']}")
                logging.info("===================================")

        except (psutil.NoSuchProcess,
                psutil.AccessDenied,
                psutil.ZombieProcess):
            pass

    if not found:
        logging.info(f"Process '{ProcessName}' is not running.")
        
def main():
    ConfigureLogger()

    try:
        ValidateInput()
        DisplayProcesses()
        ProcessName = sys.argv[1]
        SearchProcess(ProcessName)
        logging.info("Program executed successfully.")
    except Exception as e:
        logging.exception(f"Error : {e}")


if __name__ == "__main__":
    main()