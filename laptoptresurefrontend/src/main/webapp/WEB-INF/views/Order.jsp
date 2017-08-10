<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<jsp:useBean id="now" class="java.util.Date" />

 <div class="container">

      <div class="row marketing">
<form:form  action="${contextRoot}/cart/confirm/${cart.cartid}" modelAttribute="order">
      
        <div class="col-lg-12">
        
          <h4><strong>Receipt</strong></h4>
<hr />

<div>
<center>  
<h4>Success - your order is confirmed!</h4>
<h5>Order number: ORD${order.orderId}</h5>
<h6>Payment Method:- Cash On Delivery</h6>
<hr />  
</div>
</center>
        </div>

    <div class="row">
        <div class="col-xs-12">
    		<div class="row">
    			<div class="col-xs-4">
        			<address>
    				<strong>Billing Address:</strong><br>
                         ${order.cart.userdetails.address}
    				</address>

    			</div>
    			<div class="col-xs-4">
        			<address>
    				<strong>Shipping Address:</strong><br>
                         ${order.cart.userdetails.address}
    				</address>
    			</div>
    			 <div class="col-xs-4 text-right">
                  <p>Shipping Date: <fmt:formatDate type="date" value="${now}"></fmt:formatDate></p>
                </div>
    			
    		</div>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<center><p><span class="glyphicon glyphicon glyphicon-question-sign" aria-hidden="true"></span> 
                    Purchased Product Details</p></center>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Product Name</strong></td>
        							<td class="text-right"><strong>Quantity</strong></td>
            						<td class="text-right"><strong>Price</strong></td>
            						<td class="text-right"><strong>Total</strong></td>
                                    
                                </tr>
    						</thead>
    						<tbody>
    						     <c:set var="grandTotal" value="0.0"></c:set>
    						      <c:forEach var="cartItem" items="${order.cart.cartItems}">
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
    								<td><em>${cartItem.product.prodname}</em></td>
            						<td class="text-right">${cartItem.quantity}</td>
            						<td class="text-right">${cartItem.product.price}</td>
                                    <td class="text-right">${cartItem.totalPrice}</td>
                                     <c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice }"></c:set>
    							</tr>
    							</c:forEach>
    							
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-right"><h4><strong>Grand Total:</strong></h4></td>
    								<td class="no-line text-right"><h4><strong>${grandTotal}</strong></h4></td>
    							</tr>
    						
    						</tbody>
    					</table>
    					<input type="submit" class="btn1" value="Confirm">
    				</div>
    		</div>
    	</div>
    </div>
</div>
  </form:form>
     </div>
   
    </div> <!-- /container -->
