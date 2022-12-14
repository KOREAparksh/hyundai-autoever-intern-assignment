import 'package:json_annotation/json_annotation.dart';

part 'favorite_dto.g.dart';

@JsonSerializable()
class FavoriteDto {
  @JsonKey(name: "screen_id")
  String screenId;
  @JsonKey(name: "screen_url")
  String screenUrl;
  @JsonKey(name: "screen_name")
  String screenName;

  FavoriteDto(this.screenId, this.screenUrl, this.screenName);

  factory FavoriteDto.fromJson(Map<String, dynamic> json) =>
      _$FavoriteDtoFromJson(json);
  Map<String, dynamic> toJson() => _$FavoriteDtoToJson(this);

  @override
  String toString() {
    return 'FavoriteDto{screenId: $screenId, screenUrl: $screenUrl}';
  }
}
