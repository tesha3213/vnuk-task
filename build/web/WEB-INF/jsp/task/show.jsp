<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../body-open.jsp" />
        
    Id : ${tasks.id}<br/>
    Description : ${tasks.description}<br/>
    Complete : ${tasks.complete}<br/>
    Date of completion : <fmt:formatDate value="${tasks.dateOfCompletion.time}" pattern="dd/MM/yyyy" /><br/>
    
    <br/>
    
    <a href="controller?object=tasks&action=Index" class="btn btn-default">
        <i class="fa fa-undo" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Back to list
    </a>
    <a href="controller?object=tasks&action=Edit&id=${tasks.id}" class="btn btn-primary">
        <i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Modify
    </a>
        
<c:import url="../body-close.jsp" />