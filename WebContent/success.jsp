<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
</style>
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script>
$(document).ready(function() {
    var titleValidators = {
            row: '.col-xs-4',   // The title is placed inside a <div class="col-xs-4"> element
            validators: {
                notEmpty: {
                    message: 'The title is required'
                }
            }
        },
        isbnValidators = {
            row: '.col-xs-4',
            validators: {
                notEmpty: {
                    message: 'The ISBN is required'
                },
                isbn: {
                    message: 'The ISBN is not valid'
                }
            }
        },
        priceValidators = {
            row: '.col-xs-2',
            validators: {
                notEmpty: {
                    message: 'The price is required'
                },
                numeric: {
                    message: 'The price must be a numeric number'
                }
            }
        },
        bookIndex = 0;

    $('#bookForm')
        .formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                'book[0].title': titleValidators,
                'book[0].isbn': isbnValidators,
                'book[0].price': priceValidators
            }
        })

        // Add button click handler
        .on('click', '.addButton', function() {
            bookIndex++;
            var $template = $('#bookTemplate'),
                $clone    = $template
                                .clone()
                                .removeClass('hide')
                                .removeAttr('id')
                                .attr('data-book-index', bookIndex)
                                .insertBefore($template);

            // Update the name attributes
            $clone
                .find('[name="title"]').attr('name', 'book[' + bookIndex + '].title').end()
                .find('[name="isbn"]').attr('name', 'book[' + bookIndex + '].isbn').end()
                .find('[name="price"]').attr('name', 'book[' + bookIndex + '].price').end();

            // Add new fields
            // Note that we also pass the validator rules for new field as the third parameter
            $('#bookForm')
                .formValidation('addField', 'book[' + bookIndex + '].title', titleValidators)
                .formValidation('addField', 'book[' + bookIndex + '].isbn', isbnValidators)
                .formValidation('addField', 'book[' + bookIndex + '].price', priceValidators);
        })

        // Remove button click handler
        .on('click', '.removeButton', function() {
            var $row  = $(this).parents('.form-group'),
                index = $row.attr('data-book-index');

            // Remove fields
            $('#bookForm')
                .formValidation('removeField', $row.find('[name="book[' + index + '].title"]'))
                .formValidation('removeField', $row.find('[name="book[' + index + '].isbn"]'))
                .formValidation('removeField', $row.find('[name="book[' + index + '].price"]'));

            // Remove element containing the fields
            $row.remove();
        });
});
</script>

</head>
<body>
<h3>Registered Successfully！</h3>
<a href="http://localhost:8080/test/main.jsp">Result Page</a></br>
<a href="http://localhost:8080/test/register.jsp">Register Page</a>


<form id="bookForm" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="col-xs-1 control-label">Book</label>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="book[0].title" placeholder="Title" />
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="book[0].isbn" placeholder="ISBN" />
        </div>
        <div class="col-xs-2">
            <input type="text" class="form-control" name="book[0].price" placeholder="Price" />
        </div>
        <div class="col-xs-1">
            <button type="button" class="btn btn-default addButton"><i class="fa fa-plus"></i></button>
        </div>
    </div>

    <!-- The template for adding new field -->
    <div class="form-group hide" id="bookTemplate">
        <div class="col-xs-4 col-xs-offset-1">
            <input type="text" class="form-control" name="title" placeholder="Title" />
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="isbn" placeholder="ISBN" />
        </div>
        <div class="col-xs-2">
            <input type="text" class="form-control" name="price" placeholder="Price" />
        </div>
        <div class="col-xs-1">
            <button type="button" class="btn btn-default removeButton"><i class="fa fa-minus"></i></button>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-5 col-xs-offset-1">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>
</body>


</html>
