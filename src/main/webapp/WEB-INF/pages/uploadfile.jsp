<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
 <head>
 <title>XML File Upload</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 </head>
 <body>
 <script>
 $(document).ready(function (){
    $('#buttonSubmit').click(function (){

        if(document.getElementById("fileToUpload").files.length != 0){
            var file = $('#fileToUpload')[0].files[0];
            var formData = new FormData();
            formData.append("file", file);
            $.ajax({
                    type: "POST",
                    url : "${pageContext.request.contextPath}/invoice/parseXML",
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function(response){
                        if(response == "OK"){
                            $('#success').text("File Successfully uploaded!");
                            var form = $('#formUpload');
                            form.html('');
                            form.append("<a href='${pageContext.request.contextPath}/index.html'>Go Back ...</a>");
                        }
                    }
                });
        }
        else{
            console.log("Do not select a file!");
        }
    });

 });

 </script>
<h1>XML File Parse</h1>

<h3 style="color:red" id="success">${filesuccess}</h3>
<form:form method="post" action="savefile" enctype="multipart/form-data" id="formUpload">
<p><label for="image">Choose XML File</label></p>
<p><input name="file" id="fileToUpload" type="file" /></p>
<p><input type="button" value="Upload" id="buttonSubmit"></p>
</form:form>
</body>
</html>