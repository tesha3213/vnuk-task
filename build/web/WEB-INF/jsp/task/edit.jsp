<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../body-open.jsp" />

        <h1>Modify tasks</h1>
        <hr />

        <form action="controller?object=tasks&action=Update" method="post">
            Id : ${tasks.id}<br/>
            <input type="hidden" name="id" value="${tasks.id}" /><br />
            Id : <input type="text" name="id" value="${tasks.id}" /><br />
            Description : <input type="text" name="description" value="${tasks.description}" /><br />
            Complete : <input type="text" name="complete" value="${tasks.complete}" /><br />
            Date of completion : <input type="text" class="my-date-field" name="date_of_completion" id="date_of_completion" value=<fmt:formatDate value="${tasks.dateOfCompletion.time}" pattern="dd/MM/yyyy" /> /><br />
            <br/>
            <button type="submit" class="btn btn-success">
                <i class="fa fa-check" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Save
            </button>
            <a href="controller?object=tasks&action=Show&id=${tasks.id}" class="btn btn-default">
                <i class="fa fa-times-rectangle" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Cancel
            </a>
        </form>
        
        <c:import url="../footer.jsp" />
        <c:import url="../scripts.jsp" />
        
    </body>

</html>