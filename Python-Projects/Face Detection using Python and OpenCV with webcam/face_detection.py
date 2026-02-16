import cv2
import sys


def detect_faces():
    face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
    
    if face_cascade.empty():
        print("Error: Could not load Haar Cascade classifier")
        sys.exit(1)
    
    video_capture = cv2.VideoCapture(0)
    
    if not video_capture.isOpened():
        print("Error: Could not open webcam")
        sys.exit(1)
    
    print("Face detection started. Press 'q' to quit.")
    
    while True:
        ret, frame = video_capture.read()
        
        if not ret:
            print("Error: Failed to capture frame")
            break
        
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        
        faces = face_cascade.detectMultiScale(
            gray,
            scaleFactor=1.1,
            minNeighbors=5,
            minSize=(30, 30)
        )
        
        for (x, y, w, h) in faces:
            cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)
            cv2.putText(frame, 'Face', (x, y - 10), 
                       cv2.FONT_HERSHEY_SIMPLEX, 0.9, (0, 255, 0), 2)
        
        face_count = len(faces)
        cv2.putText(frame, f'Faces detected: {face_count}', (10, 30),
                   cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 0, 0), 2)
        
        cv2.imshow('Face Detection - Press Q to Quit', frame)
        
        if cv2.waitKey(1) & 0xFF == ord('q'):
            print("Quitting...")
            break
    
    video_capture.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    detect_faces()






"""
INSTALLATION STEPS
Step 1: Open Terminal in VS Code (Press `Ctrl + ``)
Step 2: Install OpenCV
bashpip install opencv-python
Step 3: Install NumPy
bashpip install numpy
Step 4: Verify Installation
bashpython -c "import cv2; print(cv2.__version__)"
Step 5: Run the Program
bashpython face_detection.py
"""
