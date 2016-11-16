# RetrofitTest

Testing Retrofit2 in android app


## Story

Testing api calls to url using retrofit2, parsing json messages with gson

- possibility to log request/responses in network_log file - managed with custom okhttp3 interceptor
- display json data in RecycleView


Tested with json output 

```
{
	"response": [{
                            "id": 1,
                            "hostname": "example1.com",
                            "name": "Company Name",
                            "address": null,
                            "phone": null,
                            "fax": null
                        }, {
                            "id": 2,
                            "hostname": "example2.com",
                            "name": "Company Name 2",
                            "address": null,
                            "phone": null,
                            "fax": null
                        }]
}

```

## Built With

* [Retrofit2] (http://square.github.io/retrofit/) - Type-safe HTTP client for Android and Java by Square, Inc.
* [okhttp3] (http://square.github.io/okhttp/) - An HTTP+HTTP/2 client for Android and Java applications. 


## TODO 

* implement database ( sqlite, realm, or similar )

