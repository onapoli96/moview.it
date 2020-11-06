
<!-- Search Widget -->


<script type="text/javascript" src="js/countries.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<div style="position: fixed;width: 23%;">

	<form action="RicercaFiltri" method="get">
		<div class="card  ">
			<h6 class="card-header">Search</h6>
			<div class="card-body">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for..."
						name="campoRicerca"> <span class="input-group-append">
					
					</span>
				</div>
			</div>
		</div>

		<!-- Categories Widget -->
		<div class="card">
			<h6 class="card-header">Genres</h6>
			<div class="card-body">
				<div class="row" style="font-size: small;">
					<div class="col-lg-4">

						<div>
							<input type="checkbox" id="Action" name="generi" value="Action">
							<label for="Action">Action</label>
						</div>

						
						<div>
							<input type="checkbox" id="Crime" name="generi" value="Crime">
							<label for="Crime">Crime</label>
						</div>

						<div>
							<input type="checkbox" id="Drama" name="generi" value="Drama">
							<label for="Drama">Drama</label>
						</div>

						

						<div>
							<input type="checkbox" id="Musical" name="generi" value="Music">
							<label for="Musical">Musical</label>
						</div>
						<div>
							<input type="checkbox" id="Short" name="generi" value="Short">
							<label for="Short">Short</label>
						</div>
					</div>
					<div class="col-lg-4">
						<div>
							<input type="checkbox" id="Adventure" name="generi"
								value="Adventure"> <label for="Adventure">Adventure</label>
						</div>
						<div>
							<input type="checkbox" id="Comedy" name="generi" value="Comedy">
							<label for="Comedy">Comedy</label>
						</div>
						
						<div>
							<input type="checkbox" id="Family" name="generi" value="Family">
							<label for="Family">Family</label>
						</div>
						<div>
							<input type="checkbox" id="Horror" name="generi" value="Horror">
							<label for="Horror">Horror</label>
						</div>
						
						<div>
							<input type="checkbox" id="Thriller" name="generi"
								value="Thriller"> <label for="Thriller">Thriller</label>
						</div>
					</div>
					<div class="col-lg-4">
						<div>
							<input type="checkbox" id="Animation" name="generi"
								value="Adventure"> <label for="Animation">Animation</label>
						</div>
						<div>
							<input type="checkbox" id="Documentary" name="generi"
								value="Documentary"> <label for="Documentary">Document.</label>
						</div>
						<div>
							<input type="checkbox" id="Fantasy" name="generi" value="Fantasy">
							<label for="Fantasy">Fantasy</label>
						</div>
						<div>
							<input type="checkbox" id="Romance" name="generi" value="Romance">
							<label for="Romance">Romance</label>
						</div>
					</div>

				</div>
			</div>
		</div>


		<div class="card ">
			<h6 class="card-header">Countries</h6>
			<div class="card-body text-center">
				
				<select class="selectpicker  w-100 " data-flag="true" name="paesi" id="country" ></select>
<script language="javascript">
				populateCountries("country");
				</script>
				
			</div>
		</div>

		<div class="card mb-3">
			<h6 class="card-header">Time Interval</h6>
			<div class="card-body text-center">
				<div slider id="slider-distance">
  <div>
    <div inverse-left style="width:70%;"></div>
    <div inverse-right style="width:70%;"></div>
    <div range style="left:40%;right:0%;"></div>
    <span thumb style="left:40%;"></span>
    <span thumb style="left:100%;"></span>
    <div sign style="left:40%;">
      <span id="value">1960</span>
    </div>
    <div sign style="left:100%;">
      <span id="value">2020</span>
    </div>
  </div>
  <input type="range" name="anno1" tabindex="0" value="1960" max="2020" min="1920" step="1" oninput="
  this.value=Math.min(this.value,this.parentNode.childNodes[5].value-1);
  var value=(100/(parseInt(this.max)-parseInt(this.min)))*parseInt(this.value)-(100/(parseInt(this.max)-parseInt(this.min)))*parseInt(this.min);
  var children = this.parentNode.childNodes[1].childNodes;
  children[1].style.width=value+'%';
  children[5].style.left=value+'%';
  children[7].style.left=value+'%';children[11].style.left=value+'%';
  children[11].childNodes[1].innerHTML=this.value;" />
  <input type="range" name="anno2" tabindex="0" value="2020" max="2020" min="1920" step="1" oninput="
  this.value=Math.max(this.value,this.parentNode.childNodes[3].value-(-1));
  var value=(100/(parseInt(this.max)-parseInt(this.min)))*parseInt(this.value)-(100/(parseInt(this.max)-parseInt(this.min)))*parseInt(this.min);
  var children = this.parentNode.childNodes[1].childNodes;
  children[3].style.width=(100-value)+'%';
  children[5].style.right=(100-value)+'%';
  children[9].style.left=value+'%';children[13].style.left=value+'%';
  children[13].childNodes[1].innerHTML=this.value;" />
</div>
			</div>
		</div>
			<input type="submit" class="btn btn-secondary w-100 mb-3" type="button" value="Go!">
	</form>
</div>



