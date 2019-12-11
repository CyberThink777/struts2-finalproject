<html lang="${.lang}">
<head>
    <#include "../template/head.ftl">
</head>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>Delete Order ${id} </h1>
            </div>
            <form action="" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <p>
                    Are you sure you want to delete order ${id}?
                </p>
                <div class="btn-group">
                    <input type="submit" value="Delete" class="btn btn-danger" />
                    <input type="button" value="Cancel" class="btn btn-success" onclick="window.location.href = '../../orders'" />
                </div>
            </form>
        </div>
    </div>
</div>
</html>