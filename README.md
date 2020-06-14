# Conf4J
> Conf4j stands for Configuration For Java.



Conf4j - One stop solution for all the configurations in your application.

![](conf4j.jpg)

## Installation



## Usage example

After importing the project/jar, just add this 2 lines of code in your project:
			ConfigurationBuilder configurationBuilder = ConfigurationBuilderFactory.createConfigurationBuilder();
			Configuration configuration = configurationBuilder.getConfiguration();
After this any configuration you need to access/get, you can do it like below:
			String property = configuration.getString("property_name");		

To make it work, add conf4j.properties file in the projects path with contents like below:

conf4j.configuration.files.Token=FILE1,FILE2

FILE1.conf4j.configuration.files.Path=<path to the configuration file>
FILE1.conf4j.configuration.files.Priority=1
FILE1.conf4j.fileWatcher.Enable=true
FILE1.conf4j.fileWatcher.Interval=60
FILE1.conf4j.backup.Enable=true
FILE1.conf4j.backup.Directory=
FILE1.conf4j.backup.Interval=86400

FILE2.conf4j.configuration.files.Path=<path to the configuration file>
FILE2.conf4j.configuration.files.Priority=2
FILE2.conf4j.fileWatcher.Enable=true
FILE2.conf4j.fileWatcher.Interval=60
FILE2.conf4j.backup.Enable=true
FILE2.conf4j.backup.Directory=
FILE2.conf4j.backup.Interval=86400


## Release History

* 0.0.1
    * Work in progress

## Meta

Vivek HJ – vivek.work@outlook.com

Distributed under the MIT license. See ``LICENSE`` for more information.

[https://github.com/vivekhj/conf4j]

## Contributing

1. Fork it (<https://github.com/vivekhj/conf4j/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

