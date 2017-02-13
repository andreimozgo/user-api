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

**2. Get user info:**

* HTTP method: GET
* URL: http://localhost/api/users/{userId} 
* where {userId} - user id

**3. Update user status:**

* HTTP method: PUT
* Content-Type: application/json
* URL: http://localhost/api/users/changestatus/


    {
      "id": 1,
      "newStatus": "Online"
    }