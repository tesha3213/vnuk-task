<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../body-open.jsp" />

        <h1>Add tasks</h1>
        <hr />

        <form action="controller?object=tasksaction=Create" method="post">
            Id : <input type="text" name="id" /><br />
            Description : <input type="text" name="description" /><br />
            Complete : <input type="text" name="complete" /><br />
            Date of completion : <input type="text" class="my-date-field" name="date_of_completion" id="date_of_completion" /><br />
            <br/>
            <button type="submit" class="btn btn-success">
                <i class="fa fa-check" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Save
            </button>
            <a href="controller?object=tasksaction=Index" class="btn btn-default">
                <i class="fa fa-times-rectangle" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Cancel
            </a>
        </form>
        
        <c:import url="../footer.jsp" />
        <c:import url="../scripts.jsp" />
        
    </body>

</html>