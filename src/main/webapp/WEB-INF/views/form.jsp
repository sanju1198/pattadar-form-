<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Pattadar Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        .form-card {
            max-width: 800px;
            margin: auto;
            padding: 30px;
            border: 2px solid #007bff;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0,0,0,0.15);
            background-color: #f8f9fa;
        }
        .form-label {
            font-weight: bold;
        }
        .form-card {
                max-width: 800px;
                margin: auto;
                padding: 30px;
                border: 2px solid #007bff;
                border-radius: 15px;
                box-shadow: 0 0 10px rgba(0,0,0,0.15);
                background-color: #f8f9fa;
            }
            .form-label {
                font-weight: bold;
            }
            .hidden-field {
                display: none;
            }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="form-card">
        <h2 class="text-center mb-4 fw-bold">Pattadar Form Input</h2>

        <form:form action="/submitForm" modelAttribute="formEntity" method="post" cssClass="needs-validation" htmlEscape="true">

            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Land Owner</label>
                    <form:input path="landOwner" cssClass="form-control" required="true"/>
                    <div class="invalid-feedback">Please enter the land owner's name.</div>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Father Name</label>
                    <form:input path="fatherName" cssClass="form-control" required="true"/>
                    <div class="invalid-feedback">Please enter the father's name.</div>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Aadhaar Number</label>
                    <form:input path="aadhaarNo" cssClass="form-control" required="true" pattern="\\d{12}"/>
                    <div class="invalid-feedback">Aadhaar number must be 12 digits.</div>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Khata No</label>
                    <form:input path="khataNo" cssClass="form-control" required="true" pattern="[A-Z0-9]+([-][A-Z0-9]+)*(/[A-Z]+)?"/>
                    <div class="invalid-feedback">Format should be like 12345/A or XYZ-6789.</div>
                </div>
            </div>

             <div class="mb-3">
                            <label class="form-label">Do you have a New Pattadar Book?</label><br/>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="newPattadarBook" value="true" cssClass="form-check-input new-pattadar-option" id="newYes"/>
                                <label class="form-check-label" for="newYes">Yes</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="newPattadarBook" value="false" cssClass="form-check-input new-pattadar-option" id="newNo"/>
                                <label class="form-check-label" for="newNo">No</label>
                            </div>

                             <div class="mb-3 hidden-field" id="newBookNoField">
                                            <label class="form-label">New Pattadar Book No</label>
                                            <form:input path="newPattadarBookNo" cssClass="form-control" pattern="[T][A-Z]{2}[A-Z]{2}[0-9]{4}"/>
                                            <div class="invalid-feedback">Format should be like TADWR1234.</div>
                                        </div>

            <div class="mb-3">
                <label class="form-label">Do you have an Old Pattadar Book?</label><br/>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="oldPattadarBook" value="true" cssClass="form-check-input" id="oldYes"/>
                    <label class="form-check-label" for="oldYes">Yes</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="oldPattadarBook" value="false" cssClass="form-check-input" id="oldNo"/>
                    <label class="form-check-label" for="oldNo">No</label>
                </div>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary px-4">Submit</button>
            </div>
        </form:form>

        <c:if test="${not empty message}">
            <div class="alert alert-info mt-3">${message}</div>
        </c:if>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
      (() => {
            'use strict'
            window.addEventListener('load', function () {
                const forms = document.getElementsByClassName('needs-validation');
                Array.prototype.forEach.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();

        // Show/hide New Pattadar Book No
        const newBookField = document.getElementById("newBookNoField");
        const radioButtons = document.querySelectorAll(".new-pattadar-option");

        radioButtons.forEach(btn => {
            btn.addEventListener("change", () => {
                if (document.getElementById("newYes").checked) {
                    newBookField.classList.remove("hidden-field");
                } else {
                    newBookField.classList.add("hidden-field");
                }
            });
        });
</script>
</body>
</html>
