import 'dart:convert';
import 'dart:io';

import 'package:flutter/foundation.dart';
import 'package:mobile/models/page_detail.dart';

class NewsClient {
//  static final W185 = 'http://image.tmdb.org/t/p/w185';
//  static final W780 = 'http://image.tmdb.org/t/p/w780';

  final _baseUrl = 'http://192.168.1.6:8085/api';

  final _client = HttpClient();

  NewsClient() {
    this._client.findProxy = findProxy;
  }

  String findProxy(Uri uri) {
    // return "PROXY 192.168.2.12:8888";
    return "DIRECT";
  }

  Future<PageDetailResponse> pageDetail({
    @required String pageId,
  }) async {
    final url = '${this._baseUrl}/page/$pageId';
    try {
      HttpClientRequest request = await this._client.getUrl(Uri.parse(url));
      HttpClientResponse response = await request.close();
      String text = (await response.transform(Utf8Decoder()).toList()).join();
      Map<String, dynamic> json = jsonDecode(text);
      return PageDetailResponse.fromJson(json);
    } catch (error) {
      print(error);
      return null;
    }
  }
}
