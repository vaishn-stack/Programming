import streamlit as st
from pathlib import Path

# -----------------------------------
# Page Configuration
# -----------------------------------
st.set_page_config(
    page_title="Vaishnavi | Developer Portfolio",
    page_icon="💻",
    layout="wide"
)

# -----------------------------------
# Resume Download
# -----------------------------------
BASE_DIR = Path(__file__).resolve().parent

RESUME_PATH = (
    BASE_DIR / "vaishnavi_resume_technical_skills1.pdf"
)

st.title("👋 Hello, I'm Vaishnavi")
st.subheader(
    "Java Backend Developer | Python Programmer | Software Developer"
)

st.write(
    "Welcome to my portfolio! I enjoy programming, "
    "backend development, problem-solving, and building "
    "practical software applications."
)

if RESUME_PATH.is_file():
    with open(RESUME_PATH, "rb") as resume_file:
        resume_data = resume_file.read()

    st.download_button(
        label="📄 Download My Resume (PDF)",
        data=resume_data,
        file_name="Vaishnavi_Morankar_Resume.pdf",
        mime="application/pdf"
    )
else:
    st.warning(
        "Resume PDF not found. Place "
        "'vaishnavi_resume_technical_skills1.pdf' "
        "in the same folder as app.py."
    )

st.markdown("---")

# -----------------------------------
# About Me
# -----------------------------------
st.header("👩‍💻 About Me")

st.write("""
I am an MCA student passionate about software development,
programming, and technology.

I have an interest in Java backend development, Python
programming, C and C++ fundamentals, data structures,
algorithms, and database-driven applications.

I enjoy learning new technologies, improving my coding
skills, solving logical problems, and building projects
that demonstrate my technical knowledge.
""")

# -----------------------------------
# Technical Skills
# -----------------------------------
st.header("🛠️ Technical Skills")

tab1, tab2, tab3, tab4 = st.tabs([
    "Java",
    "Python",
    "C Programming",
    "C++"
])

with tab1:
    st.subheader("Java Development")
    st.write("""
    - Core Java and Object-Oriented Programming (OOP)
    - Classes, objects, inheritance, polymorphism
    - Abstraction and encapsulation
    - Exception handling and Collections Framework
    - Multithreading and file handling
    - JDBC fundamentals
    - Spring Boot and REST API development
    - Hibernate / JPA fundamentals
    """)

with tab2:
    st.subheader("Python Programming")
    st.write("""
    - Python fundamentals, variables and data types
    - Conditional statements, loops and functions
    - Lists, tuples, sets and dictionaries
    - Object-Oriented Programming
    - File handling and exception handling
    - Modules and packages
    - NumPy and Pandas for data manipulation
    - Matplotlib for data visualization
    - Scikit-learn fundamentals for machine learning
    - Streamlit for interactive web applications
    - Boto3 fundamentals for AWS automation
    """)

with tab3:
    st.subheader("C Programming")
    st.write("""
    - Variables, data types and operators
    - Conditional statements and loops
    - Functions and recursion
    - Arrays and strings
    - Pointers and pointer arithmetic
    - Structures and unions
    - Dynamic memory allocation
    - File handling
    - Searching and sorting algorithms
    - Data structures fundamentals
    """)

with tab4:
    st.subheader("C++ Programming")
    st.write("""
    - C++ fundamentals and syntax
    - Classes and objects
    - Constructors and destructors
    - Inheritance and polymorphism
    - Encapsulation and abstraction
    - Function and operator overloading
    - Pointers and references
    - Templates fundamentals
    - Standard Template Library (STL)
    - Vectors, stacks, queues and maps
    - Data structures and algorithms
    """)

# -----------------------------------
# Additional Technical Skills
# -----------------------------------
st.header("⚙️ Tools and Technologies")

col1, col2, col3 = st.columns(3)

with col1:
    st.subheader("Databases")
    st.write("""
    - MySQL
    - MongoDB
    - SQL queries
    - CRUD operations
    """)

with col2:
    st.subheader("Development Tools")
    st.write("""
    - Visual Studio Code
    - IntelliJ IDEA
    - Git and GitHub
    - Postman
    - Linux fundamentals
    """)

with col3:
    st.subheader("Cloud and Web")
    st.write("""
    - AWS S3 fundamentals
    - AWS EC2 fundamentals
    - Streamlit
    - HTML and CSS fundamentals
    - REST APIs
    """)

# -----------------------------------
# Projects
# -----------------------------------
st.header("🚀 My Projects")

with st.container(border=True):
    st.subheader("1. EduTrack - Student Management Portal")
    st.write("**Technologies:** Java, Spring Boot, MongoDB")
    st.write("""
    A student management application designed to organize
    student information and perform CRUD operations.
    It demonstrates backend development and database integration.
    """)
    st.link_button(
        "View GitHub Profile",
        "https://github.com/vaishn-stack/Programming"
    )

with st.container(border=True):
    st.subheader("2. Marvellous Study Tracker")
    st.write("**Technologies:** Java, Swing, File Handling")
    st.write("""
    A desktop application for recording study sessions,
    tracking study duration, displaying records, and
    importing or exporting data using CSV files.
    """)
    st.link_button(
        "Explore GitHub",
        "https://github.com/vaishn-stack/Programming"
    )


# -----------------------------------
# Python Project: System Surveillance
# -----------------------------------
with st.container(border=True):
    st.subheader("3. System Surveillance Automated Tool")

    st.write(
        "**Technologies:** Python, OS, Process Monitoring, "
        "System Automation, Logging"
    )

    st.write("""
    A Python automation project designed for system and
    process surveillance.

    The project demonstrates system monitoring, process
    management, automated monitoring tasks, and log-based
    activity tracking.
    """)

    st.markdown("**Key Learning Areas:**")
    st.write("""
    - Python automation
    - Operating system interaction
    - Process monitoring
    - Logging and error handling
    - Command-line execution
    """)

    st.link_button(
        "View Python Project on GitHub",
        "https://github.com/vaishn-stack/Programming/tree/main/Python/Competitive/Project/System_Survillance_Automated_Tool"
    )


with st.container(border=True):
    st.subheader("4. C and C++ Programming Practice")
    st.write("**Technologies:** C, C++, Data Structures")
    st.write("""
    A collection of programming exercises focused on
    logical problem-solving, functions, arrays, pointers,
    object-oriented programming, and algorithms.
    """)
    st.link_button(
        "View Programming Repository",
        "https://github.com/vaishn-stack/Programming"
    )

# -----------------------------------
# Areas of Interest
# -----------------------------------
st.header("🎯 Areas of Interest")

st.write("""
- Java Backend Development
- Python Programming and Automation
- Data Structures and Algorithms
- Object-Oriented Programming
- Database Management
- Cloud Computing and AWS
- Software Development
""")

# -----------------------------------
# Education
# -----------------------------------
st.header("🎓 Education")

st.subheader("Master of Computer Applications (MCA)")
st.write("Currently pursuing MCA.")

st.subheader("Bachelor of Business Administration in Computer Applications")
st.write("BBA(CA) - Completed")

# -----------------------------------
# Contact
# -----------------------------------
st.header("📬 Contact Me")

st.write("Email: morankarvaishnavi5@gmail.com")

st.markdown(
    "[GitHub](https://github.com/vaishn-stack/Programming) | "
    "[LinkedIn](https://www.linkedin.com/in/"
    "vaishnavi-morankar-633a76327)"
)

st.markdown("---")

st.caption("© 2026 Vaishnavi | Developer Portfolio")
