<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<label for="file">Choose a file:</label>
	<input type="file" name="file" id="file">
	<button id="uploadBtn">Upload</button>

    <script type="text/javascript">
    
    document.getElementById('uploadBtn').addEventListener('click', function (e) {
        e.preventDefault(); // 폼 제출을 방지합니다.

        // 파일 입력 요소
        const fileInput = document.getElementById('file');
        const file = fileInput.files[0]; // 선택한 첫 번째 파일

        // 파일이 선택되었는지 확인
        if (!file) {
            alert('Please choose a file to upload.');
            return;
        }

        // FormData 객체 생성
        const formData = new FormData();
        formData.append('file', file); // 'file'은 서버에서 받을 파라미터 이름

        // fetch API로 파일 업로드
        fetch('/file/upload', {
            method: 'POST',
            body: formData,
        })
        .then(response => response.json()) // 서버에서 JSON 응답을 받을 경우
        .then(data => {
            console.log('Upload success:', data);
            alert('File uploaded successfully');
        })
        .catch(error => {
            console.error('Error uploading file:', error);
            alert('File upload failed');
        });
    });
    
    </script>

</body>
</html>