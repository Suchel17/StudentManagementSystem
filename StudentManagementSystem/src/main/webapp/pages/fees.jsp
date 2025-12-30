<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

		<div class="d-flex justify-content-center align-center">
		
			<div class="w-50 align-middle border border-info border-3 mt-2" style="height: 500px">
				<h1 class="p-3 text-primary">
					<u>Installment Details</u>
				</h1>
				
				<div class="border border-secondary m-3 p-2">
					<table class="table table-hover border border-secondary">
						<tbody>
							<tr class="table table-primary fs-6">
								<th>Student Id</th>
								<td>${stu.studentId}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>Student Name</th>
								<td>${stu.studentFullName}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>Email </th>
								<td>${stu.studentEmail}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>Age</th>
								<td>${stu.studentAge}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>College</th>
								<td>${stu.studentCollegeName}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>Batch Number</th>
								<td>${stu.batchNumber}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>Batch Mode</th>
								<td>${stu.batchMode}</td>
							</tr>
							<tr class="table table-primary fs-6">
								<th>Course</th>
								<td>${stu.studentCourse}</td>
							</tr>
							<tr class="table table-danger fs-6">
								<th>Fees Paid</th>
								<td>${stu.feesPaid}</td>
							</tr>	
							
						</tbody>
					</table>
					
					<form action="payfees"> 
        				<input type="text" name="studentId" value="${stu.studentId}" hidden="true"> 
        					<div class="bg-dark p-2  d-flex justify-content-between"> 
        						<label for="amount" class="text-info"><b>Enter Installment<br> 
								Amount</b></label> 
        						<input type="number" name="ammount" > 
        					</div> 
        	 					<div class="d-flex justify-content-center pt-5"> 
        							<button class="btn btn-success btn-sm ">Add Installment</button> 
        						</div> 
        			</form> 
					
				</div>
				
			</div>
		
		</div>		

</body>
</html>