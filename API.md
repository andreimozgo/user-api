***Available requests:***

**1. Add new user:**

* HTTP method: POST
* Content-Type: application/json
* URL: http://localhost/api/users


    {
      "avatar": "https://www.google.by/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png",
      "name": "AMozgo",
      "email": "a.mozgo@gmail.com"
    }
    
    
* Response example:


    {
      "id": 1
    }

**2. Get user info:**

* HTTP method: GET
* URL: http://localhost/api/users/{userId} 
* where {userId} - user id
* Response example:


    {
      "id": 4,
      "name": "AMozgo",
      "avatar": "https://www.google.by/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png",
      "email": "a.mozgo@gmail.com",
      "status": "Offline"
    }

**3. Update user status:**

* HTTP method: PUT
* Content-Type: application/json
* URL: http://localhost/api/users/changestatus/


    {
      "id": 1,
      "newStatus": "Online"
    }
    
* Response example:


    {
      "id": 1,
      "previousStatus": "Offline",
      "newStatus": "Online"
    }