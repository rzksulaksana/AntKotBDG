<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="program.model.SemutModel"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>Hasil Pencarian Rute</title>
    <style>
      #right-panel {
        font-family: 'Roboto','sans-serif';
      }

      #right-panel select, #right-panel input {
        font-size: 15px;
      }

      #right-panel select {
        width: 100%;
      }

      #right-panel i {
        font-size: 12px;
      }
      html, body {
        height: 100%;
        margin-left:10px;
        padding: 0;
      }
      #map {
        height: 87%;
        float: left;
        width: 40%;
      }
      #right-panel {
        width: 20%;
        height: 87%;
        float: left;
        padding-left: 10px;
        text-align: left;
      }
      #directions-panel {
        padding: 5px;
        height:100%;
        background-color: #FFEE77;
      }
      #angkot-panel {
        width: 39%;
        height: 87%;
        float: right;
        padding-left: 30px;
        text-align: left;
        background-color: #F0E68C;
      }
      
    </style>
  </head>
  
  <body>
       <script src="https://code.jquery.com/jquery.js"></script>
       <script src="js/bootstrap.min.js"></script>
      <h1 class="display-2">Rute Yang Dilalui</h1>
      <div id="map"></div>
    
    <%  
            int start = (int) request.getAttribute("asal");
            int finish = (int) request.getAttribute("tujuan");
                                
            SemutModel km = new SemutModel();
            List<SemutModel> data_asal = new ArrayList<SemutModel>();
            List<SemutModel> data_tujuan = new ArrayList<SemutModel>();
                                 
            String ket = request.getParameter("ket");
            if (ket == null) {
                data_asal = km.LatLong(start);
                data_tujuan = km.LatLong(finish);
            } 
            for (int x = 0; x < data_asal.size(); x++) {%>
            <input id="start" type="hidden" value="<%out.println(data_asal.get(x).getLatitude());%>,<%out.println(data_asal.get(x).getLongitude());%>"></input>
            <%}
            for (int y = 0; y < data_tujuan.size(); y++) {%>
            <input id="end" type="hidden" value="<%out.println(data_tujuan.get(y).getLatitude());%>,<%out.println(data_tujuan.get(y).getLongitude());%>"></input>
            <%}
        %>
       
    <select multiple id="waypoints" hidden="true" >
    <%
        if (request.getAttribute("tamp") != null) {
            SemutModel tr = new SemutModel();
            ArrayList itemsArray = (ArrayList) request.getAttribute("tamp");
            List<List<SemutModel>> latlongtrayek = new ArrayList<>();
            List<SemutModel> temp = new ArrayList<>();
            String ket2 = request.getParameter("ket");

            if (ket2 == null) {
                for (int i=0; i < itemsArray.size(); i++) {
                    latlongtrayek.add(tr.LatLong((int)itemsArray.get(i)));
                }

                for (int i=1; i < latlongtrayek.size()-1; i++) {%>
                <option value="<%out.println(latlongtrayek.get(i).get(0).getLatitude());%>,<%out.println(latlongtrayek.get(i).get(0).getLongitude());%>"></options>
                <%}   
            }
        }
    %>
    </select>
    <script>
      function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: {lat:-6.914744 , lng:107.609810 }
        });
        directionsDisplay.setMap(map);

        
          calculateAndDisplayRoute(directionsService, directionsDisplay);
   
      }

      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var waypts = [];
        var checkboxArray = document.getElementById('waypoints');
        for (var i = 0; i < checkboxArray.length; i++) {
          
            waypts.push({
              location: checkboxArray[i].value,
              stopover: true
            });
          
        }

        directionsService.route({
          origin: document.getElementById('start').value,
          destination: document.getElementById('end').value,
          waypoints: waypts,
          optimizeWaypoints: true,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
            var route = response.routes[0];
            var summaryPanel = document.getElementById('directions-panel');
            summaryPanel.innerHTML = '';
            summaryPanel.innerHTML += '<center><b><font size=5>Jalur Yang Dilalui : </b><br></center>';
            // For each route, display summary information.
            for (var i = 0; i < route.legs.length; i++) {
              var routeSegment = i + 1;
              summaryPanel.innerHTML +=  routeSegment +'. ' ;
              summaryPanel.innerHTML += route.legs[i].start_address + ' ke ';
              summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
              summaryPanel.innerHTML += '<br><br>';
              //summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
            }
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD7q62LpGm-J4lAUa-oNjyjwsPQfaSIxKg&callback=initMap">
    </script>
 
    <div id="right-panel">
    <div id="directions-panel"></div>
    </div>
    <div id="angkot-panel">
        <center><h1 class="display-4" >Angkot Yang Dapat Digunakan</h1></center>
        <%
            if (request.getAttribute("hasil") != null) {
                ArrayList itemsArray = (ArrayList) request.getAttribute("hasil");
                //out.println(itemsArray);
                //out.println(itemsArray.size());

                for (int i=0; i < itemsArray.size(); i++) {
                    //out.println(itemsArray.get(i));
                    if(Objects.equals("01.A",itemsArray.get(i))){
                        %><img src="images/1A.jpg" width=80% height=50%/>
                         <h1 class="display-4" >Abdul Muis - Cicaheum Via Binong</h1>
                    <%
                    }else if(Objects.equals("01.B",itemsArray.get(i))){
                        %><img src="images/1B.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Abdul Muis - Cicaheum Via Aceh</h1>
                    <%
                    }else if(Objects.equals("02",itemsArray.get(i))){
                        %><img src="images/2.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Abdul Muis - Dago</h1>
                    <%
                    }else if(Objects.equals("03",itemsArray.get(i))){
                        %><img src="images/3.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Abdul Muis - Ledeng</h1>
                    <%
                    }else if(Objects.equals("04",itemsArray.get(i))){
                        %><img src="images/4.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Abdul Muis - Elang</h1>
                    <%
                    }else if(Objects.equals("05",itemsArray.get(i))){
                        %><img src="images/5.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Cicaheum - Ledeng</h1><%
                    }else if(Objects.equals("06",itemsArray.get(i))){
                        %><img src="images/6.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Cicaheum - Ciroyom</h1<%
                    }else if(Objects.equals("07",itemsArray.get(i))){
                        %><img src="images/7.jpg" width=80% height=50%/>
                        <h1 class="display-4" >Cicaheum - Ciwastra - Derwati</h1>
                        <%
                    }else if(Objects.equals("08",itemsArray.get(i))){
                        %><img src="images/8.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Cicaheum - Cibaduyut</h1>
                        <%
                    }else if(Objects.equals("15",itemsArray.get(i))){
                        %><img src="images/15.jpg" width=80% height=50%/>
                          <h1 class="display-4" >Margahayu Raya - Ledeng</h1>
                        <%
                    }

                }
            }

            else {
                out.println("no data in array");

            }
        %>
    </div>
  </body>
</html>