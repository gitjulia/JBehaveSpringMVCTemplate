<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form id="feedback_form" modelAttribute="feedbackInfo">
		<table>
			<tr>
				<td>
					Sender:
				</td>
				<td>
					<form:input path="sender"/>
				</td>
			</tr>
			<tr>
				<td>
					Recipient:
				</td>
				<td>
					<form:input path="recipient"/>
				</td>
			</tr>
			<tr>
				<td>
					Feedback:
				</td>
				<td>
					<form:input path="feedback"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					 <input id="submitFeedbackButton" type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>

    <form name="feedbackRecipientForm" action="/" method="GET" id="feedback_recipient_form">
        <table>
            <tr>
                <td>
                    <label id="label-for-recipient-search-form-id" for="recipientSearchFormId">Recipient:</label>
                </td>
                <td>
                    <input id="recipientSearchFormId" name="recipientSearchFormId" type="text" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="submitRecipientButton" type="submit" name="search" value="Search" />
                </td>
            </tr>
        </table>
    </form>

    <c:forEach items="${feedbackList}" var="feedbackContent" varStatus="index">
        <div id="feedback${index.count}">
            Sender: <c:out value="${feedbackContent.sender}"></c:out>
            Recipient: <c:out value="${feedbackContent.recipient}"></c:out>
            Feedback: <c:out value="${feedbackContent.feedbackDescription}"></c:out>
        </div>
    </c:forEach>
</body>
</html>