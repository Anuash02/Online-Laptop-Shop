<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
<div class="row">
<div class="col-sm-6">
<a href="${contextRoot}/cart/clearcart/${cart.cartid}" class="btn btn-danger pull-left ">
</a>
</div>


<div class="col-sm-6">
<a href="${contextRoot}/cart/order/${cart.cartid}" class="btn btn-success pull-right ">Check Out</a>

</div>
</div>
<table class="table table-striped">
<thead>
<tr><th>Name</th><th>Quantity</th><th>Total Price</th><th>Remove</th>
</tr>
</thead>
<c:set var="grandTotal" value="0"></c:set>
<c:forEach items="${cart.cartItems}" var="cartItem">
<tr>
<td>${cartItem.product.prodname}</td>
<td>${cartItem.quantity}</td>
<td>${cartItem.totalPrice}</td>
<td><a href="${contextRoot}/cart/removecartitem/${cartItem.cartItemId}" class="btn btn-danger pull-left ">
<c:set var="grandTotal" value="${cartItem.totalPrice + grandTotal}"></c:set>remove</a></td>
<td></td>
</tr>
</c:forEach> 
</table>
Total Price:${grandTotal}


</div>