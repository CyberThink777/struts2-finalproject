<#--TODO I18N-->
<div class="modal fade" id="deleteConfirm" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="POST" action="/book/${id}">
                <input type="hidden" name="_method" value="DELETE"/>
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel"><@s.text name="delete.confirm"/></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <@s.text name="delete.confirm.msg"/> ${model.title}?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal"><@s.text name="button.cancel"/></button>
                <button type="submit" class="btn btn-primary"><@s.text name="button.confirm"/></button>
            </div>
            </form>
        </div>
    </div>
</div>