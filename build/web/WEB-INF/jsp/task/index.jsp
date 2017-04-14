<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../body-open.jsp" />

    <a href="controller?object=tasks&action=New" class="btn btn-primary">
        <i class="fa fa-plus" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Create a new tasks
    </a>
    <br/>
    <br/>

    <table class="table table-bordered table-responsive table-striped table-hover">

        <thead>
            <tr>
                <th><i>Actions</i></th>
                <th>Id</th>
                <th>Description</th>
                <th>Complete</th>
                <th>Date of completion</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach var="tasks" items="${tasks}">

                <tr>
                    <td>
                        <a href="controller?object=tasks&action=Show&id=${tasks.id}" class="btn btn-xs btn-info">
                            <i class="fa fa-search" aria-hidden="true" data-toggle="tooltip" title="Show" data-placement="bottom"></i>
                        </a>
                        <a href="controller?object=tasks&action=Delete&id=${tasks.id}" class="btn btn-xs btn-danger">
                            <i class="fa fa-trash" aria-hidden="true" data-toggle="tooltip" title="Delete" data-placement="bottom"></i>
                        </a>
                    </td>
                    <td>${tasks.id}</td>
               
                   
                    <td>${tasks.complete}</td>
                    <%-- <td>${tasks.dateOfBirth.time}</td> --%>
                    <td>
                        <fmt:formatDate value="${tasks.dateOfCompletion.time}" pattern="dd/MM/yyyy" />
                    </td>

                </tr>
            </c:forEach>

        </tbody>

    </table>
        
<c:import url="../body-close.jsp" />