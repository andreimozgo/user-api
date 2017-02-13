Available requests:

1. Add new user:
HTTP method POST
Content-Type Json
URL://localhost/api/users

    {
      "avatar": "https://www.google.by/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png",
      "name": "AMozgo",
      "email": "a.mozgo@gmail.com"
    }

2. Get user info:
HTTP method GET

URL://localhost/api/users/

parameters: userId

3. Update user status:
HTTP method PUT
Content-Type Json
URL://localhost/api/users/changestatus/

    {
      "id": 1,
      "newStatus": "Online"
    }