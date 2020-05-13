import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/pages/home_page.dart';

void main() {
  NewsClient client = NewsClient();
  runApp(App(client: client));
}

class App extends StatelessWidget {
  final NewsClient client;

  App({@required this.client});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "News",
      theme: ThemeData(
        // Define the default brightness and colors.
        brightness: Brightness.dark,
      ),
      home: HomePage(client: this.client),
    );
  }
}
