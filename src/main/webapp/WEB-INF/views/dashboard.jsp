<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
   <head>
      <meta charset="utf-8" />
      <title>Spring Boot + JPA + Datatables</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
      <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
   </head>
   <body>
      <div id="filter-panel" class="collapse filter-panel row">
         <div class="panel panel-default">
            <div class="row">
               <div class="panel-body col-sm-3">
                  <div class="form-group">
                     <label class="filter-col" style="margin-right:0;" for="pref-orderby">Seat:</label>
                     <select id="pref-orderby" class="form-control">
                        <option>5</option>
                        <option>15</option>
                        <option>20</option>
                        <option>25</option>
                     </select>
                  </div>
                  <div class="form-group col-sm-3">
                     <label class="filter-col" style="margin-right:0;" for="pref-orderby">Room:</label>
                     <select id="pref-orderby" class="form-control">
                        <option>Room A</option>
                        <option>Room B</option>
                        <option>Room C</option>
                        <option>Room D</option>
                     </select>
                  </div>
               </div>
               <div class="row">
                  <div class="form-group col-sm-3">
                     <label class="filter-col" style="margin-right:0;" for="pref-orderby">Floor:</label>
                     <select id="pref-orderby" class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                     </select>
                  </div>
                  <div class="form-group col-sm-3">
                     <label class="filter-col" style="margin-right:0;" for="pref-orderby">Event:</label>
                     <select id="pref-orderby" class="form-control">
                        <option>Event A</option>
                        <option>Event B</option>
                        <option>Event C</option>
                        <option>Event D</option>
                     </select>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="row">
         <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#filter-panel">
         <span class="glyphicon glyphicon-cog"></span> Advanced Search
         </button>
      </div>
      <div class="row">
         <table id="meetingtbl" class="display">
            <!-- Header Table -->
            <thead>
               <tr>
                  <th style="display: none;">Id</th>
                  <th>Event Name</th>
                  <th>Start Time</th>
                  <th>End Time</th>
                  <th>Actor</th>
               </tr>
            </thead>
         </table>
      </div>
      <script type="text/javascript">
         jQuery.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
         {
         return {
         "iStart":         oSettings._iDisplayStart,
         "iEnd":           oSettings.fnDisplayEnd(),
         "iLength":        oSettings._iDisplayLength,
         "iTotal":         oSettings.fnRecordsTotal(),
         "iFilteredTotal": oSettings.fnRecordsDisplay(),
         "iPage":          oSettings._iDisplayLength === -1 ?
         0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
         "iTotalPages":    oSettings._iDisplayLength === -1 ?
         0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
         };
         };
         
         $(document).ready( function () {
          var table = $('#meetingtbl').DataTable({
                 "processing": true,
                 "serverSide": true,
                 "ajaxSource": "${pageContext.request.contextPath}/fetchAll",
                 "serverMethod": "POST",
                 "destroy":true,
                 "columns": [
                  	{ "data": "id" , "visible": false},
                     { "data": "eventName" },
                     { "data": "startTime" },
                     { "data": "endTime" },
                     { "data": "owner" }
                 ]
             });
         });
      </script>
   </body>
</html>