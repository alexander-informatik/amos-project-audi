	function aConfig(){}
	aConfig.prototype.url = {};
	aConfig.prototype.url.json = {};
	aConfig.prototype.url.json.gpscoordinate = {};
	aConfig.prototype.url.json.gpscoordinate.getall;
	aConfig.prototype.url.json.gpscoordinate.send;
	aConfig.prototype.url.json.gpscoordinate.update;
	aConfig.prototype.url.json.gpscoordinate._delete;
	aConfig.prototype.imgFolder;
	aConfig.prototype.latlng_default;
	aConfig.prototype.editor = {};
	aConfig.prototype.editor.routeMarkers = {};
	aConfig.prototype.editor.routeMarkers.isDraggable;
	aConfig.prototype.editor.routeMarkers.isAddOnMouseClick;
	aConfig.prototype.geolocation = {};
	aConfig.prototype.geolocation.isOn;
	aConfig.prototype._new = {};
	aConfig.prototype._new.createNewMarkerFromGpsCoordinate = {};
	aConfig.prototype._new.createNewMarkerFromGpsCoordinate.apply;
	
	var aconfig = aconfig || new aConfig();
	aconfig._new.createNewMarkerFromGpsCoordinate.apply = [];
	
	function aGpsPosition(p1, p2)
	{
		if(p1!=undefined && p2==undefined)
		{
			if(p1 instanceof google.maps.LatLng)
			{
				console.log("ctor 2 google.maps.LatLng");
				this.latitude = p1.lat();
				this.longitude = p1.lng();
			}
			else
			{
				console.log("ctor 2 other");
				var geolocationposition = p1;
				
				this.timestamp = geolocationposition.timestamp;
		
				this.latitude = geolocationposition.coords.latitude;
				this.longitude = geolocationposition.coords.longitude;
				this.altitude = geolocationposition.coords.altitude;
				this.accuracy = geolocationposition.coords.accuracy;
				this.altitudeAccuracy = geolocationposition.coords.altitudeAccuracy;
				this.heading = geolocationposition.coords.heading;
				this.speed = geolocationposition.coords.speed;
			}
		}
		else if(p1!=undefined && p2!=undefined)
		{
			console.log("ctor 1");
			var lat = p1;
			var lng = p2;

			this.latitude = lat;
			this.longitude = lng;
		}
		else if(p1==undefined && p2==undefined)
		{
			console.log("ctor 0");
		}
	}

	aGpsPosition.prototype.toLatLng = function()
	{
		return new google.maps.LatLng(this.latitude, this.longitude);
	}

	aGpsPosition.prototype.getDistance = function(other)
	{
		var olat;
		var olong;

		if(other instanceof google.maps.LatLng)
		{
			olat = other.lat();
			olong = other.lng();
		}
		else
		if(other instanceof aGpsPosition)
		{
			olat = other.latitude;
			olong = other.longitude;
		}
		else
		{
			alert("Error: Other coordinate is not of compatible type!");
			return;
		}

		return getDistanceFromGps( this.longitude, this.latitude, olong, olat );
	}


	function aMarker(title, icontype, latlng, map, gpscoordinate)
	{
		this.marker = new google.maps.Marker();
		if(title!=undefined)
		{
			this.marker.setTitle(title);
		}
		if(icontype!=undefined)
		{
			this.iconType = icontype;
			var image = getIcon(icontype);
			this.marker.setIcon(image);
		}
		if(latlng!=undefined)
		{
			this.marker.setPosition(latlng);
		}
		if(map!=undefined)
		{
			this.marker.setMap(map);
		}
		if(gpscoordinate!=undefined)
		{
			this.gpsCoordinate = gpscoordinate;
		}	
	}

	aMarker.prototype.getPosition = function()
	{
		return this.marker.getPosition();
	}

	aMarker.prototype.getIcon = function()
	{
		return this.marker.getIcon();
	}

	aMarker.prototype.getLatLng = function()
	{
		return this.marker.getPosition();
	}

	aMarker.prototype.getDistance = function(other)
	{
		return this.marker.getPosition.getDistance(other);
	}

	aMarker.prototype.getMarker = function()
	{
		return this.marker;
	}

	aMarker.prototype.getGpsCoordinate = function()
	{
		return this.gpsCoordinate;
	}

	aMarker.prototype.getIconType = function()
	{
		return this.iconType;
	}

	aMarker.prototype.getGpsPosition = function()
	{
		return new aGpsPosition(this.marker.GetPosition());
	}

	aMarker.prototype.getMap = function()
	{
		return this.marker.getMap();
	}

	


	aMarker.prototype.setIcon = function(val)
	{
		if(val==undefined)
		{
			val = getIcon(this.iconType);
		}
		return this.marker.setIcon(val);
	}

	aMarker.prototype.setPosition = function(val)
	{
		return this.marker.setPosition(val);
	}

	aMarker.prototype.setLatLng = function(val)
	{
		return this.marker.setPosition(val);
	}

	aMarker.prototype.setMarker = function(val)
	{
		this.marker = val;
	}

	aMarker.prototype.setGpsCoordinate = function(val)
	{
		this.gpsCoordinate = val;
	}

	aMarker.prototype.setIconType = function(val)
	{
		this.iconType = val;
	}

	aMarker.prototype.setMap = function(val)
	{
		this.marker.setMap(val);
	}




	aMarker.prototype.setCallback = function(name, callbackFunction)
	{
		var myclass = this;
		google.maps.event.addListener(this.marker, name, function(event){callbackFunction(myclass, event);});
	}

	aMarker.prototype.setCallbackAnimationChanged = function(f)
	{
		this.setCallback("animation_changed",f);
	}

	aMarker.prototype.setCallbackClick = function(f)
	{
		this.setCallback("click",f);
	}

	aMarker.prototype.setCallbackClickableChanged = function(f)
	{
		this.setCallback("clickable_changed",f);
	}

	aMarker.prototype.setCallbackCursorChanged = function(f)
	{
		this.setCallback("cursor_changed",f);
	}

	aMarker.prototype.setCallbackDoubleClick = function(f)
	{
		this.setCallback("dblclick",f);
	}

	aMarker.prototype.setCallbackDrag = function(f)
	{
		this.setCallback("drag",f);
	}

	aMarker.prototype.setCallbackDragEnd = function(f)
	{
		this.setCallback("dragend",f);
	}

	aMarker.prototype.setCallbackDraggableChanged = function(f)
	{
		this.setCallback("draggable_changed",f);
	}

	aMarker.prototype.setCallbackDragStart = function(f)
	{
		this.setCallback("dragstart",f);
	}

	aMarker.prototype.setCallbackFlatChanged = function(f)
	{
		this.setCallback("flat_changed",f);
	}

	aMarker.prototype.setCallbackIconChanged = function(f)
	{
		this.setCallback("icon_changed",f);
	}

	aMarker.prototype.setCallbackMouseDown = function(f)
	{
		this.setCallback("mousedown",f);
	}

	aMarker.prototype.setCallbackMouseOut = function(f)
	{
		this.setCallback("mouseout",f);
	}

	aMarker.prototype.setCallbackMouseOver = function(f)
	{
		this.setCallback("mouseover",f);
	}

	aMarker.prototype.setCallbackMouseUp = function(f)
	{
		this.setCallback("mouseup",f);
	}

	aMarker.prototype.setCallbackPositionChanged = function(f)
	{
		this.setCallback("position_changed",f);
	}

	aMarker.prototype.setCallbackRightClick = function(f)
	{
		this.setCallback("rightclick",f);
	}

	aMarker.prototype.setCallbackShadowChanged = function(f)
	{
		this.setCallback("shadow_changed",f);
	}

	aMarker.prototype.setCallbackShapeChanged = function(f)
	{
		this.setCallback("shape_changed",f);
	}

	aMarker.prototype.setCallbackTitleChanged = function(f)
	{
		this.setCallback("title_changed",f);
	}

	aMarker.prototype.setCallbackVisibleChanged = function(f)
	{
		this.setCallback("visible_changed",f);
	}

	aMarker.prototype.setCallbackZIndexChanged = function(f)
	{
		this.setCallback("zindex_changed",f);
	}

	

	function aMap()
	{
		var myclass = this;
		this.test = "it works";

		this.latlng_default = aconfig.latlng_default;
		this.map;
		this.marker_currentLocation;
		this.idxNextWaypoint = 0;
		this.WaypointDetectionDistance = 50;
	
		this.directionsDisplay = new google.maps.DirectionsRenderer();
		this.directionsService = new google.maps.DirectionsService();
		

		var myOptions = 
		{
			zoom: 18,
			center: this.latlng_default,
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			mapTypeControlOptions: 
			{
	        		mapTypeIds: [google.maps.MapTypeId.HYBRID, google.maps.MapTypeId.TERRAIN, google.maps.MapTypeId.ROADMAP, google.maps.MapTypeId.SATELLITE],
	        		style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR
	      		}
		};
		
		this.map = new google.maps.Map(window.document.getElementById("map_canvas"), myOptions);
		this.map.setCenter(this.latlng_default);


		this.route_markersArray = new Array();
		this.drawPathRoute = new google.maps.Polyline(
		{
		    strokeColor: '#FF0000',
		    strokeOpacity: 1.0,
	   	    strokeWeight: 2
	 	 });
	
	
		this.drawPath_currentLocation_to_nextWaypoint = new google.maps.Polyline(
		{
		   strokeColor: '#00FF00',
		   strokeOpacity: 1.0,
		   strokeWeight: 2
		});
	
		this.gpsoptions = 
		{
			enableHighAccuracy: true,
			timeout: 5000,
			maximumAge: 20000
		};
	
		if(true == aconfig.geolocation.isOn)
		{
			if (window.navigator.geolocation)
			{
				this.watchId = window.navigator.geolocation.watchPosition
				(
					function(pos) { myclass.device_newgps_received(new aGpsPosition(pos)); },
					this.device_gpserror, 
					this.gpsoptions
				);
			}
			else
			{
				alert("Geolocation not supported with this webbrowser!");
			}
		}

		if(true == aconfig.editor.routeMarkers.isAddOnMouseClick)
		{
			google.maps.event.addListener(this.map,"click",function(clickpos)
			{
				myclass.sendgps(clickpos.latLng.lat().toString(), clickpos.latLng.lng().toString());
			});
		}
	}

	aMap.prototype.setDeviceToGps = function(lat,lng)
	{
		this.device_newgps_received(new aGpsPosition(lat,lng));
	}

	aMap.prototype.setDeviceToGpsByWaypoint = function(id)
	{
		if(id < this.route_markersArray.length)
		{
			var nextWaypointMarker =  this.route_markersArray[id];
			var nextWaypoint =  nextWaypointMarker.getPosition();
			this.device_newgps_received(new aGpsPosition(nextWaypoint));
		}
		else
		{
			console.log("setDeviceToGpsByWaypoint: id must be between 0 and " + this.route_markersArray.length-1);
		}
		
	}

	aMap.prototype.initializeMap = function() 
	{
		//directionsDisplay.setMap(map);
		//directionsDisplay.setPanel(document.getElementById("directionsPanel"));
		//calcRoute();


		this.showallgps();
	}

	function getIcon(icontype)
	{
		var stem = aconfig.imgFolder;
		var ext = '.png';
		var image;
		if(0 == icontype.localeCompare("start"))
		{
			image = '_start';
		}
		else
		if(0 == icontype.localeCompare("finish"))
		{
			image = '_finish';
		}
		else
		if(0 == icontype.localeCompare("currentlocation"))
		{
			image = '_currentlocation';
		}
		else
		if(0 == icontype.localeCompare("current"))
		{
			image = '_current';
		}
		else
		{
			image = '';
		}

		return stem+image+ext;
	}



	aMap.prototype.createNewMarkerFromGpsCoordinate = function(gpscoordinate, icontype)
	{
		var myclass = this;

		var latlng = new google.maps.LatLng(gpscoordinate.latitude, gpscoordinate.longitude);
		var newMarker = new aMarker(gpscoordinate.orderedposition.toString(),icontype,latlng,this.map,gpscoordinate);

			//newMarker.setDraggable(true);
			//newMarker.setPosition(latlng);
			//this.route_markersArray.push(newMarker);


			

		if(true == aconfig.editor.routeMarkers.isDraggable)
		{
			newMarker.getMarker().setDraggable(true);

			//google.maps.event.addListener(newMarker.getMarker(), "dragend", function(event)
			//{
      			//	var position = newMarker.getPosition();
			//	myclass.updategps(gpscoordinate.id,position.lat().toString(),position.lng().toString());
			//});

			newMarker.setCallbackDragEnd(function(marker,e)
			{
				var position = marker.getPosition();
				myclass.updategps(gpscoordinate.id,position.lat().toString(),position.lng().toString());
			});
		}

		
		for(var key in aconfig._new.createNewMarkerFromGpsCoordinate.apply)
		{
			aconfig._new.createNewMarkerFromGpsCoordinate.apply[key](newMarker);
			
		}

		return newMarker;
	}

	
	aMap.prototype.showallgps = function()
	{	
		var myclass = this;
		this.removeMarkersFromMap(this.route_markersArray);
		// load gps coordinates	
		$.getJSON(aconfig.url.json.gpscoordinate.getall, function(data)
		{
			console.log("showallgps get json");
			$.each(data, function(i, item)
			{
				var icontype = "default";
				if(0 == i)
				{
					icontype = "start";
					//this.map.setCenter(new google.maps.LatLng(item.latitude, item.longitude));
				}
				if(data.length-1 == i)
				{
					icontype = "finish";
				}
				var m = myclass.createNewMarkerFromGpsCoordinate(item,icontype);
				myclass.route_markersArray.push(m);
			
				console.log("showallgps.gps lat/long: " + item.latitude + "," + item.longitude);
			});

			
			myclass.drawPath(myclass.route_markersArray);
		});
	
	}

	aMap.prototype.sendgps = function(latitude, longitude, callback)
	{
		var myclass = this;

		var thing = { longitude: longitude , latitude: latitude }
		
		$.postJSON(aconfig.url.json.gpscoordinate.send, thing, function(data) 
		{
			console.log("sendgps json post");
			myclass.showallgps();

			if(undefined!=callback)
			{
				callback(data);
			}
		});
	}

	aMap.prototype.updategps = function(id, latitude, longitude, callback)
	{
		var myclass = this;

		var thing = { id: id, longitude: longitude , latitude: latitude }
		
		$.postJSON(aconfig.url.json.gpscoordinate.update, thing, function(data) 
		{
			console.log("updategps");
			myclass.showallgps();

			if(undefined!=callback)
			{
				callback(data);
			}
		});
		
	}


	aMap.prototype.deletegps = function(id, callback)
	{
		var myclass = this;

		$.ajax(
		{
   			url: aconfig.url.json.gpscoordinate._delete+id,
    			type: 'DELETE',
    			success: function(data)
			{
        			console.log("deletegps.success");
				myclass.showallgps();
	
				if(undefined!=callback)
				{
					callback(data);
				}
    			},
			error: function(data)
			{
				console.log("deletegps.error");
				console.log(data);
			},
			abort: function(data)
			{
				console.log("deletegps.abort");
				console.log(data);
			},
			parsererror: function(data)
			{
				console.log("deletegps.parseerror");
				console.log(data);
			}
		});

	}

	aMap.prototype.drawPath = function(markersArray)
	{
		var path = [];
    		for(var key in markersArray)
		{
        		path.push(markersArray[key].getPosition());
    		}
		this.drawPathRoute.setPath(path);
		this.drawPathRoute.setMap(this.map);
	}

	aMap.prototype.removeMarkersFromMap = function(markersArray)
	{
		for(var i = 0;	i < markersArray.length;i++	)
		{
    			markersArray[i].setMap(null);	
		}
		markersArray.splice(0,markersArray.length);
	}



	aMap.prototype.calcRoute = function() 
	{

		var start = "${gpsstart}";
		var ende = "${gpsend}";
		var reglang = "en";


		var request = 
		{
			origin:start, 
        		destination:ende,
        		travelMode: google.maps.DirectionsTravelMode.WALKING,
			region:reglang
		};


    		this.directionsService.route(request, function(response, status) 
		{
			if (status == google.maps.DirectionsStatus.OK)
			{
				directionsDisplay.setDirections(response);
			}
		});

	}  


	aMap.prototype.device_newgps_received = function(pos)
	{
		var latlng = pos.toLatLng();	
		this.map.setCenter(latlng);
		
		if(!this.marker_currentLocation)
		{
			this.marker_currentLocation = new aMarker("Your location!","currentlocation",latlng,this.map);
		}
		else
		{
			this.marker_currentLocation.setPosition(latlng);
		}

		if(this.idxNextWaypoint < this.route_markersArray.length)
		{
			var nextWaypointMarker =  this.route_markersArray[this.idxNextWaypoint];
			var nextWaypoint =  nextWaypointMarker.getPosition();
			var d = latlng.getDistance( nextWaypoint );
			
			if(d < this.WaypointDetectionDistance)
			{
				nextWaypointMarker.setIcon();
				this.idxNextWaypoint++;
			}
		}

		if(this.idxNextWaypoint < this.route_markersArray.length)
		{
			var nextWaypointMarker =  this.route_markersArray[this.idxNextWaypoint];
			var nextWaypoint =  nextWaypointMarker.getPosition();
			nextWaypointMarker.setIcon(getIcon("current"));

			positions=new Array();
			positions[0] = latlng;
			positions[1] = nextWaypoint;
			this.drawPath_currentLocation_to_nextWaypoint.setPath(positions);
			this.drawPath_currentLocation_to_nextWaypoint.setMap(this.map);
		}
		else
		{
			this.drawPath_currentLocation_to_nextWaypoint.setMap(null);	
		}
	}

	aMap.prototype.device_gpserror = function(err)
	{
	}

	//Geolocation.prototype.mytest = function()
	function t()
	{
		alert("position test");
	}

	google.maps.LatLng.prototype.getDistance = function(otherLatLng)
	{
		return getDistanceFromGps( this.lng(), this.lat(), otherLatLng.lng(), otherLatLng.lat() );
	}

	function getDistanceFromGps(lon1, lat1, lon2, lat2)
	{
		var R = 6371; // Radius of the earth in km
		var dLat = (lat2-lat1).toRad();
		var dLon = (lon2-lon1).toRad(); 
		var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		       	Math.cos(lat1.toRad()) * Math.cos(lat2.toRad()) * 
		      	Math.sin(dLon/2) * Math.sin(dLon/2); 
		var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		var d = R * c * 1000; // Distance in m
  		return d;
	}

/** Converts numeric degrees to radians */
	if (typeof(Number.prototype.toRad) === "undefined") 
	{
  		Number.prototype.toRad = function() 
		{
    			return this * Math.PI / 180;
  		}
	}
