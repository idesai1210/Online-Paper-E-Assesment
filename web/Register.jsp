<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Register Here</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/cssClient/fv.css" type="text/css" />
        <script>
            //            function CallCountry()
            //            {
            //                document.f1.hid.value=document.f1.country.value;
            //                document.f1.action="${pageContext.request.contextPath}/LoadServlet/Country";
            //                f1.submit();
            //                
            //            }
            function a1()
            {
                alert("123");
            }
        </script>
    </head>
    <body>

        <c:if test="${couList==null || sList==null || cList==null || sqList==null || ugList==null || pgList==null}">
            <c:redirect url="LoadServlet/FormData"/>
        </c:if>


        <div id='wrap'>

            <h1  align='center'class="webkit">REGISTER HERE!!</h1>
            <section class='form'>
                <form name="f1" action="${pageContext.request.contextPath}/LoadServlet/Insert" method="post" novalidate>
                                <fieldset>
                                    <legend> Personal Info</legend>

                                    <div class="item">
                                        <label>
                                            <span>First Name</span>
                                            <input data-validate-length-range="3" name="firstname" id="firstname" placeholder="FirstName" required="required" data-validate-pattern="alphabet" type="text"  onfocus=""/>		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Name must be in Alphabets. E.g 'John'.F.Kennedy</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Middle Name</span>
                                            <input data-validate-length-range="5" name="middlename" id="lastname" placeholder="MiddleName" required="required" type="text" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Name must be in Alphabets. E.g John.'F'.Kennedy</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Last Name</span>
                                            <input data-validate-length-range="5" name="lastname" id="lastname" placeholder="LastName" required="required" type="text" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Name must be in Alphabets. E.g John.F.'Kennedy'</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Address</span>
                                            <input data-validate-length-range="2"  name="address" id="address" placeholder="E.g. 10,Blueport Road, Blueport City" required="required" type="text" height='' />		
                                        </label>

                                    </div>

                                    <div class="item">
                                        <label>
                                            <span>Country</span>

                                            <select class="required" name="country" id="country" onchange="CallCountry();">
                                                <option value="">-- none --</option>
                                                <c:forEach var="couList" items="${couList}">
                                                    <option value="${couList.couId}">${couList.couName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Choose a country you reside in.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>State</span>
                                            <select class="required" name="state" id="state">
                                                <option value="">-- none --</option>
                                                <c:forEach var="sList" items="${sList}">
                                                    <option value="${sList.sId}">${sList.sName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Choose Your Current state.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>City</span>
                                            <select class="required" name="city" id="city">
                                                <option value="">-- none --</option>
                                                <c:forEach var="cList" items="${cList}">
                                                    <option value="${cList.cId}">${cList.cName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Choose Your Current City.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>PinCode</span>
                                            <input data-validate-length-range="4,7" name="pincode" id="pincode" placeholder="Pincode" required="required" type="text" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Name must be in Alphabets. E.g John.'F'.Kennedy</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <label>
                                            <span>Gender</span>
                                            <input name="gen" id="gen" value="male"  type="radio"> <label>Male </label>                                                 
                                            <input name="gen" id="gen" value="female"  type="radio" /><label>Female</label>
                                        </label>

                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Select Your Gender</p>
                                            </div>
                                        </div>


                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Mobile Number</span>
                                            <input type="text"  name="number"  id="number" data-validate-length-range="10,10" data-validate-pattern="numeric" required='required' placeholder="9898989898">
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Enter 10-Digit Valid Mobile Number.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Telephone</span>
                                            <input type="text" name="telphone" id="telephone" required='required' data-validate-pattern="numeric" placeholder="+912692230101">
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Notice that for a phone number user can input a '+' sign, a dash '-' or a space ' '</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Date Of Birth</span>
                                            <input class='date' type="date" name="dob" id="dob" required='required' placeholder="1/11/1111">
                                        </label>
                                    </div>
                                </fieldset>
                    
                                <fieldset>
                                    <legend>Account Info</legend>
                                    <div class="item">
                                        <label>
                                            <span>Email</span>
                                            <input name="email" id="email" class='email' required="required" type="email" placeholder="xyz@abc.com"/>
                                        </label>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Alternate email</span>
                                            <input type="email" class='email' name="altemail"  id="altemail" required='required' placeholder="xyz@abc.com"/>
                                        </label>
                                    </div>

                                    <div class="item">
                                        <label>
                                            <span>UserName</span>
                                            <input data-validate-length-range="15" data-validate-words="1" name="username"  id="username" required="required" type="text" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Select your AlphaNumeric unique Username</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Password</span>
                                            <input type="password" name="password" id="password" data-validate-length="6,8" required='required' placeholder="********"/>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Should be of length 6 OR 8 characters</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Repeat password</span>
                                            <input type="password" name="password2" id="password2" data-validate-linked='password' required='required' placeholder="********"/>
                                        </label>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>User Type</span>
                                            <select class="required" name="usertype" id="usertype">
                                                <option value="">-- none --</option>
                                                <option value="1">Faculty</option>
                                                <option value="2">Head Of Department</option>
                                                <option value="3">Supplementary Personnel</option>

                                            </select>
                                        </label>

                                    </div>
                                </fieldset>
                                <fieldset>
                                    <legend>Security Info</legend>
                                    <div class="item">
                                        <label>
                                            <span>Security Question</span>
                                            <select class="required" name="secques1" id="secques1">
                                                <option value="">-- none --</option>
                                                <c:forEach var="sqList" items="${sqList}">
                                                    <option value="${sqList.sqId}">${sqList.sqDesc}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Your choice based Security Question</p>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Answer</span>
                                            <input data-validate-length-range="15" data-validate-words="1" name="answer1" id="answer1" required="required" type="text" placeholder="Answer" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Your choice based Answer</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Security Question</span>

                                            <select class="required" name="secques2" id="secques2">
                                                <option value="">-- none --</option>
                                                <c:forEach var="sqList" items="${sqList}">
                                                    <option value="${sqList.sqId}">${sqList.sqDesc}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Your choice based Security Question</p>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Answer</span>
                                            <input data-validate-length-range="15" data-validate-words="1" name="answer2" id="answer2" required="required" type="text" placeholder="Answer" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Your choice based Answer</p>
                                            </div>
                                        </div>
                                    </div>

                                </fieldset>
                
                                <fieldset>
                                    <legend> Professional Info</legend>
                                    <div class="item">
                                        <label>
                                            <span>Under-Graduation</span>
                                            <select class="required" name="graduate_id" id="graduate_id">
                                                <option value="">-- none --</option>
                                                <c:forEach var="ugList" items="${ugList}">
                                                    <option value="${ugList.ugId}">${ugList.ugName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Choose your under-graduate degree </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Post-Graduation</span>
                                            <select class="required" name="postgraduate_id" id="postgraduate_id">
                                                <option value="">-- none --</option>
                                                <c:forEach var="pgList" items="${pgList}">
                                                    <option value="${pgList.pgId}">${pgList.pgName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Choose Your post-graduate degree</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Other Qualifications</span>
                                            <input data-validate-length-range="15" data-validate-words="1" name="other_qualification" id="other_qualification" type="text" />		
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>other Qualification. If any.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <br>

                                    <div class="item">
                                        <label>
                                            <span>College</span>
                                            <select class="required" name="college_id" id="college_id">
                                                <option value="">-- none --</option>
                                                <c:forEach var="collList" items="${collList}">
                                                    <option value="${collList.collId}">${collList.collName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Your Current college name</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Degree</span>
                                            <select class="required" name="degree_id" id="degree_id">
                                                <option value="">-- none --</option>
                                                <c:forEach var="degList" items="${degList}">
                                                    <option value="${degList.degId}">${degList.degName}</option>  
                                                </c:forEach>
                                            </select>
                                        </label>
                                        <div class='tooltip help'>
                                            <span>?</span>
                                            <div class='content'>
                                                <b></b>
                                                <p>Degree where you are employed.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Date Of Joining</span>
                                            <input class='date' type="date" name="doj" id="doj" required='required' placeholder="1/11/1111">
                                        </label>
                                    </div>
                                    <div class="item">
                                        <label>
                                            <span>Experience</span>
                                            <input data-validate-length-range="15" data-validate-words="1" name="experience" id="experience" type="text" />		
                                        </label>
                                    </div>
                                </fieldset>
                                <input type="submit" name="submit1" id="submit1" value="REGISTER"  />	
                
                </form>	
            </section>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/multifield.js"></script>
        <script src="js/validator.js"></script>

        <script src="../js/jquery.min.js"></script>
        <script src="../js/multifield.js"></script>
        <script src="../js/validator.js"></script>

        <script >
            /*
       Validator v1.0.5
       (c) 2012 Yair Even Or <http://dropthebit.com>
	
       MIT-style license.
             */

            var validator = (function(){
                var message, tests, checkField, validate, mark, unmark, field, minmax, defaults,
                validateWords, lengthRange, lengthLimit, pattern, alertTxt, data,
                email_illegalChars = /[\(\)\<\>\,\;\:\\\/\"\[\]]/,
                email_filter = /^.+@.+\..{2,3}$/;

                /* general text messages
                 */
                message = {
                    invalid			: 'invalid input',
                    empty			: 'please put something here',
                    min				: 'input is too short',
                    max				: 'input is too long',
                    number_min		: 'too low',
                    number_max		: 'too high',
                    url				: 'invalid URL',
                    number			: 'not a number',
                    email			: 'email address is invalid',
                    email_repeat	: 'emails do not match',
                    password_repeat	: 'passwords do not match',
                    repeat			: 'no match',
                    complete		: 'input is not complete',
                    select			: 'Please select an option'
                };
	
                // defaults
                defaults = { alerts:true };
	
                /* Tests for each type of field (including Select element)
                 */		
                tests = {
                    sameAsPlaceholder : function(a){
                        return $.fn.placeholder && a.attr('placeholder') !== undefined && data.val == a.prop('placeholder');
                    },
                    hasValue : function(a){
                        if( !a ){
                            alertTxt = message.empty;
                            return false;
                        }
                        return true;
                    },
                    // 'linked' is a special test case for inputs which their values should be equal to each other (ex. confirm email or retype password)
                    linked : function(a,b){
                        if( b != a ){
                            // choose a specific message or a general one
                            alertTxt = message[data.type + '_repeat'] || message.no_match;
                            return false;
                        }
                        return true;
                    },
                    email : function(a){
                        if ( !email_filter.test( a ) || a.match( email_illegalChars ) ){
                            alertTxt = a ? message.email : message.empty;
                            return false;
                        }
                        return true;
                    },
                    text : function(a){
                        // make sure there are at least X number of words, each at least 2 chars long.
                        // for example 'john F kenedy' should be at least 2 words and will pass validation
                        if( validateWords ){
                            var words = a.split(' ');
                            // iterrate on all the words
                            var wordsLength = function(len){
                                for( var w = words.length; w--; )
                                    if( words[w].length < len )
                                        return false;
                                return true;
                            };
				
                            if( words.length < validateWords || !wordsLength(2) ){
                                alertTxt = message.complete;
                                return false;
                            }
                            return true;
                        }
                        if( lengthRange && a.length < lengthRange[0] ){
                            alertTxt = message.min;
                            return false;
                        }
                        // check if there is max length & field length is greater than the allowed
                        if( lengthRange && lengthRange[1] && a.length > lengthRange[1] ){
                            alertTxt = message.max;
                            return false;
                        }
                        // check if the field's value should obey any length limits, and if so, make sure the length of the value is as specified
                        if( lengthLimit && lengthLimit.length ){
                            var obeyLimit = false;
                            while( lengthLimit.length ){
                                if( lengthLimit.pop() == a.length )
                                    obeyLimit = true;
                            }
                            if( !obeyLimit ){
                                alertTxt = message.complete;
                                return false;
                            }
                        }
		
                        if( pattern ){
                            var regex, jsRegex;
                            switch( pattern ){
                                case 'alphanumeric' :
                                    regex = /^[a-z0-9]+$/i;
                                    break;
                                case 'numeric' :
                                    regex = /^[0-9]+$/i;
                                    break;
                                case 'phone' :
                                    regex = /^\+?([0-9]|[-|' '])+$/i;
                                    break;
                                default :
                                    regex = pattern;
                            }
                            try{
                                jsRegex = new RegExp("^"+regex+"$").test(a);
                                if( a && !jsRegex )
                                    return false;
                            }
                            catch(err){
                                console.log(err, field, 'regex is invalid');
                                return false;
                            }
                        }
                        return true;
                    },
                    number : function(a){
                        // if not not a number
                        if( isNaN(parseFloat(a)) && !isFinite(a) ){
                            alertTxt = message.number;
                            return false;
                        }
                        // not enough numbers
                        else if( lengthRange && a.length < lengthRange[0] ){
                            alertTxt = message.min;
                            return false;
                        }
                        // check if there is max length & field length is greater than the allowed
                        else if( lengthRange && lengthRange[1] && a.length > lengthRange[1] ){
                            alertTxt = message.max;
                            return false;
                        }
                        else if( minmax[0] && (a|0) < minmax[0] ){
                            alertTxt = message.number_min;
                            return false;
                        }
                        else if( minmax[1] && (a|0) > minmax[1] ){
                            alertTxt = message.number_max;
                            return false;
                        }
                        return true;
                    },
                    // Date is validated in European format (day,month,year)
                    date : function(a){
                        var day, A = a.split(/[-./]/g), i;
                        // if there is native HTML5 support:
                        if( field[0].valueAsNumber )
                            return true;

                        for( i = A.length; i--; ){
                            if( isNaN(parseFloat(a)) && !isFinite(a) )
                                return false;
                        }
                        try{
                            day = new Date(A[2], A[1]-1, A[0]);
                            if( day.getMonth()+1 == A[1] && day.getDate() == A[0] ) 
                                return day;
                            return false;
                        }
                        catch(er){
                            console.log('date test: ', err);
                            return false;
                        }
                    },
                    url : function(a){
                        // minimalistic URL validation 
                        function testUrl(url){
                            return /^(https?:\/\/)?([\w\d\-_]+\.+[A-Za-z]{2,})+\/?/.test( url );
                        }
                        if( !testUrl( a ) ){
                            console.log(a);
                            alertTxt = a ? message.url : message.empty;
                            return false;
                        }
                        return true;
                    },
                    hidden : function(a){
                        if( lengthRange && a.length < lengthRange[0] ){
                            alertTxt = message.min;
                            return false;
                        }
                        if( pattern ){
                            var regex;
                            if( pattern == 'alphanumeric' ){
                                regex = /^[a-z0-9]+$/i;
                                if( !regex.test(a) ){
                                    return false;
                                }
                            }
                        }
                        return true;
                    },
                    select : function(a){
                        if( !tests.hasValue(a) ){
                            alertTxt = message.select;
                            return false;
                        }
                        return true;
                    }
                };
	
                /* marks invalid fields
                 */  
                mark = function(field, text){
                    if( !text || !field || !field.length )
                        return false;
		
                    // check if not already marked as a 'bad' record and add the 'alert' object.
                    // if already is marked as 'bad', then make sure the text is set again because i might change depending on validation
                    var item = field.parents('.item'), warning;
        
                    item.find('.alert').remove();
        
                    if( defaults.alerts ){
                        warning = $('<div>').addClass('alert').text( text );
                        item.append( warning );
                    }
        
                    item.removeClass('bad');
                    setTimeout(function(){
                        item.addClass('bad');
                    }, 0);
                };
                /* un-marks invalid fields
                 */
                unmark = function(field){
                    if( !field || !field.length ){
                        console.warn('no "field" argument, null or DOM object not found')
                        return false;
                    }
                    field.parents('.item')
                    .removeClass('bad')
                    .find('.alert').animate({ marginLeft:32, opacity:0 }, 200, function(){
                        $(this).remove();
                    });
                };
	
                function testByType(type, value){
                    switch( type ){
                        case 'email' :
                            return tests.email(value);
                        case 'text' :
                            return tests.text(value);
                        case 'tel' :
                            pattern = pattern || 'phone';
                            return tests.text(value);
                        case 'password' :
                            return tests.text(value);
                        case 'number' :
                            return tests.number(value);
                        case 'date' :
                            return tests.date(value);
                        case 'url' :
                            return tests.url(value);
                        case 'select' :
                            return tests.select(value);
                        case 'hidden' :
                            return tests.hidden(value);
                    }
                    return true;
                }
	
                function prepareFieldData(el){
                    field = $(el);
		
                    field.data( 'valid',true );										// every field starts as 'valid=true' until proven otherwise
                    field.data( 'type', field.attr('type') );						// every field starts as 'valid=true' until proven otherwise
                    data = field.data();  											// cache the custom data attributes.
                    pattern = el.pattern;
		
                }
	
                /* Validations per-character keypress 
                 */
                function keypress(e){
                    prepareFieldData(this);
		
                    if( e.charCode )
                        return testByType( data.type, String.fromCharCode(e.charCode) );
                }
	
                /* Checks a single form field by it's type and specific (custom) attributes
                 */
                function checkField(){
                    // skip testing fields whom their type is not HIDDEN but they are HIDDEN via CSS.
                    if( this.type !='hidden' && $(this).is(':hidden') )
                        return true;
			
                    prepareFieldData(this);

                    field.data( 'val', field[0].value.replace(/^\s+|\s+$/g, "") );	// cache the value of the field and trim it
		
                    // Check if there is a specific error message for that field, if not, use the default 'invalid' message
                    alertTxt = message[field.prop('name')] || message.invalid;
		
                    // SELECT / TEXTAREA nodes needs special treatment
                    if( field[0].nodeName.toLowerCase() === "select" ){
                        data.type = 'select';
                    }
                    if( field[0].nodeName.toLowerCase() === "textarea" ){
                        data.type = 'text';
                    }
                    /* Gather Custom data attributes for specific validation:
                     */
                    validateWords	= data['validateWords'] || 0;
                    lengthRange 	= data['validateLengthRange'] ? (data['validateLengthRange']+'').split(',') : [1];
                    lengthLimit		= data['validateLength'] ? (data['validateLength']+'').split(',') : false;
                    minmax			= data['validateMinmax'] ? (data['validateMinmax']+'').split(',') : ''; // for type 'number', defines the minimum and/or maximum for the value as a number.

                    /* Validate the field's value is different than the placeholder attribute (and attribute exists)
                     * this is needed when fixing the placeholders for older browsers which does not support them.
                     * in this case, make sure the "placeholder" jQuery plugin was even used before proceeding
                     */
                    if( tests.sameAsPlaceholder(field) ){
                        alertTxt = msg.form.empty;
                        data.valid = false;
                    }

                    // if this field is linked to another field (their values should be the same)
                    if( data.validateLinked ){
                        var linkedTo = data['validateLinked'].indexOf('#') == 0 ? $(data['validateLinked']) : $(':input[name=' + data['validateLinked'] + ']');
                        data.valid = tests.linked( data.val, linkedTo.val() );
                    }
                    /* validate by type of field. use 'attr()' is proffered to get the actual value and not what the browsers sees for unsupported types.
                     */
                    else if( data.valid = tests.hasValue(data.val) || data.type == 'select' )
                        data.valid = testByType(data.type, data.val);

                    // optional fields are only gets validated if they are not empty
                    if( field.hasClass('optional') && !data.val )
                        data.valid = true;
		
                    // mark / unmark the field, and set the general 'submit' flag accordingly
                    if( data.valid )
                        unmark( field );
                    else{
                        mark( field, alertTxt );
                        submit = false;
                    }
		
                    return data.valid;
                }
	
                /* vaildates all the REQUIRED fields prior to submiting the form
                 */
                function checkAll( $form ){
                    if( $form.length == 0 ){
                        console.warn('element not found');
                        return false;
                    }

                    var that = this,
                    submit = true, // save the scope
                    fieldsToCheck = $form.find(':input').filter('[required=required], .required, .optional').not('[disabled=disabled]');

                    fieldsToCheck.each(function(){
                        // use an AND operation, so if any of the fields returns 'false' then the submitted result will be also FALSE
                        submit = submit * checkField.apply(this);
                    });
		
                    return !!submit;  // casting the variable to make sure it's a boolean
                }
	
                return {
                    defaults 	: defaults,
                    checkField 	: checkField,
                    keypress 	: keypress,
                    checkAll 	: checkAll,
                    mark 		: mark,
                    unmark		: unmark,
                    message		: message,
                    tests 		: tests
                }
            })();
        </script>

        <script>
            // initialize the validator function
            validator.message['date'] = 'not a real date';

            // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
            $('form')
            .on('blur', 'input[required], input.optional, select.required', validator.checkField)
            .on('change', 'select.required', validator.checkField)
            .on('keypress', 'input[required][pattern]', validator.keypress);

            $('.multi.required')
            .on('keyup blur', 'input', function() {
                validator.checkField.apply($(this).siblings().last()[0]);
            });

            // bind the validation to the form submit event
            //$('#send').click('submit');//.prop('disabled', true);

            $('form').submit(function(e) {
                e.preventDefault();
                var submit = true;
                // evaluate the form using generic validaing
                if (!validator.checkAll($(this))) {
                    submit = false;
                }

                if (submit)
                    this.submit();
                return false;
            });

            /* FOR DEMO ONLY */
            $('#vfields').change(function() {
                $('form').toggleClass('mode2');
            }).prop('checked', false);

            $('#alerts').change(function() {
                validator.defaults.alerts = (this.checked) ? false : true;
                if (this.checked)
                    $('form .alert').remove();
            }).prop('checked', false);
        </script>
    </body>
</html>