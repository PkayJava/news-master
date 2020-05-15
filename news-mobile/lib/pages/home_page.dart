import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/widget.dart';
import 'package:mobile/models/page_detail.dart';

class HomePage extends StatelessWidget {
  final NewsClient client;

  const HomePage({@required this.client});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      builder: buildPage,
      future: client.pageDetail(
        pageId: 'uuid_001',
      ),
    );
  }

  Widget buildPage(
      BuildContext context, AsyncSnapshot<PageDetailResponse> snapshot) {
    if (!snapshot.hasData) {
      return Container();
    } else {
      return buildWidget(
        context,
        snapshot.data.object['type'],
        snapshot.data.object['attrs'],
      );
    }
  }
}
